package com.cn.springthreadpool.task;

import com.alibaba.fastjson.JSON;
import com.cn.springthreadpool.config.TaskConfig;
import com.cn.springthreadpool.entity.*;
import com.cn.springthreadpool.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 消息推送任务，一次性
 * @version 创建时间：2019/2/19
 */
@Slf4j
public class MessagePushTask implements Runnable {

	private PushMessage pushMessage;

	private TaskConfig taskConfig;

	private StringRedisTemplate stringRedisTemplate;

	private ScheduledExecutorService scheduledExecutorService;

	private PushMessageService pushMessageService;

	private RestTemplate restTemplate;

	private String url;

	private String secret;

	public MessagePushTask(PushMessage pushMessage, TaskConfig taskConfig){
		this.pushMessage=pushMessage;
		this.taskConfig=taskConfig;
		this.stringRedisTemplate=taskConfig.getStringRedisTemplate();
		this.scheduledExecutorService=taskConfig.getScheduledExecutorService();
		this.pushMessageService=taskConfig.getPushMessageService();
		this.restTemplate=taskConfig.getRestTemplate();
		this.secret = taskConfig.getSecret();
	}

	/**
	 * 推送消息，成功：更新db消息状态；
	 * 失败：1、判断是否达到最大重试次数，是则更新消息状态为cancel，
	 * 否则新建定时任务加入线程池（时间间隔延长）
	 */
	@Override
	public void run() {
		log.debug("开始推送消息[{}]",pushMessage.getUuid());
		//发送前查询消息最新状态，避免重复发送
		PushMessage dbPushMessage=pushMessageService.findByUUid(pushMessage.getUuid());
		log.debug("查询消息[{}]",pushMessage.getUuid());
		if(dbPushMessage==null){
			log.warn("数据异常，消息[{}]不存在",pushMessage.getUuid());
			return;
		}
		if(dbPushMessage.getStatus().equals(MessageStatusEnum.SUCCESS.value()) || dbPushMessage.getStatus().equals(MessageStatusEnum.CANCEL.value())){
			log.warn("消息[{}]最新状态为{}，跳过本次发送",pushMessage.getUuid(),MessageStatusEnum.desc(pushMessage.getStatus()));
			return;
		}

		boolean result=send(new PushMessageDto(pushMessage));

		log.debug("第{}次推送{}消息[{}]，{}",pushMessage.getTryCount()+1,pushMessage.getType(),pushMessage.getUuid(),result ? "成功":"失败");
		if(result){
			pushMessage.setTryCount(pushMessage.getTryCount()+1);
			pushMessage.setLastTryTime(new Date());
			pushMessage.setStatus(MessageStatusEnum.SUCCESS);

			pushMessageService.updateMessage(pushMessage);
			stringRedisTemplate.delete(TaskConstant.MESSAGE_KEY_PREFIX+pushMessage.getUuid());
		}else {
			pushMessage.setTryCount(pushMessage.getTryCount()+1);
			pushMessage.setLastTryTime(new Date());

			if(pushMessage.getTryCount()>=TaskConstant.MAX_TRY_COUNT){
				//执行失败且超过最大执行次数，更新消息状态为3
				pushMessage.setStatus(MessageStatusEnum.CANCEL);
				stringRedisTemplate.delete(TaskConstant.MESSAGE_KEY_PREFIX+pushMessage.getUuid());
			}else{
				//执行失败，新建发送任务，增加延时
				MessagePushTask messagePushTask=new MessagePushTask(pushMessage,taskConfig);
				//下次发送时间间隔
				int delaySeconds;
				if((pushMessage.getTryCount()+1)<=TaskConstant.DELAY_SECONDS_ARR.length){
					delaySeconds=TaskConstant.DELAY_SECONDS_ARR[pushMessage.getTryCount()];
				}else {
					delaySeconds=TaskConstant.DELAY_SECONDS_ARR[TaskConstant.DELAY_SECONDS_ARR.length-1];
				}
				log.debug("计划{}秒后第{}次推送{}消息[{}]",delaySeconds,pushMessage.getTryCount()+1,pushMessage.getType(),pushMessage.getUuid());
				scheduledExecutorService.schedule(messagePushTask,delaySeconds,TimeUnit.SECONDS);
			}

			pushMessageService.updateMessage(pushMessage);
		}
	}

	public boolean send(PushMessageDto pushMessageDto){
		log.debug("url地址[{}]",url);

		//获取当前时间
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dateString = ldt.format(dtf);

		//开始发送前，统计总发送次数
		try{
			log.debug("统计消息发送总次开始");
			String keySum = TaskConstant.MESSAGE_SUM_PREFIX+dateString;
			Long statistics = statistics(keySum);
			log.debug("统计消息发送总次结束[{}],",statistics);
		}catch (Exception e){
			log.error("统计消息发送总次数异常[{}]",e);
		}

		pushMessageDto.sign(secret);
		log.debug("sign="+pushMessageDto.getSign());
		Map<String, Object> map = JSON.parseObject(JSON.toJSONString(pushMessageDto));
		//String postForObject1 = restTemplate.postForObject("http://mall.mozi.link/api/v1/message", map, String.class);
		ResponseEntity<RtnDto> responseEntity;
		try{

			responseEntity=restTemplate.postForEntity(url,map, RtnDto.class);
		}catch (Exception e){
			log.error("消息[{}]推送异常:",pushMessageDto.getUuid(),e);
			return false;
		}

		//发送完成后，统计发送成功数

		try {
			String keySuc = TaskConstant.MESSAGE_SUC_PREFIX+dateString;
			statistics(keySuc);
		}catch (Exception e){
			log.error("统计消息发送成功次数异常{}",e);
		}


		log.debug("消息[{}]推送结果，状态码[{}]",pushMessageDto.getUuid(),responseEntity.getStatusCode());

		return responseEntity.getStatusCode().equals(HttpStatus.OK);
	}


	/**
	 * 统计发送次数
	 * @param key
	 */
	private Long statistics(String key){

		String s = stringRedisTemplate.opsForValue().get(key);
		if (StringUtils.isEmpty(s)){
			stringRedisTemplate.opsForValue().set(key,"1",365*100,TimeUnit.DAYS);
		}

		Long increment = stringRedisTemplate.opsForValue().increment(key,1);

		stringRedisTemplate.opsForValue().set(key,String.valueOf(increment),365*100,TimeUnit.DAYS);

		return increment;
	}

}
