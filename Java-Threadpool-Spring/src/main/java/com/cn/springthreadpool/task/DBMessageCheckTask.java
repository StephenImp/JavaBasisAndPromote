package com.cn.springthreadpool.task;

import com.cn.springthreadpool.config.TaskConfig;
import com.cn.springthreadpool.entity.MessageStatusEnum;
import com.cn.springthreadpool.entity.PushMessage;
import com.cn.springthreadpool.entity.QueryDto;
import com.cn.springthreadpool.entity.TaskConstant;
import com.cn.springthreadpool.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import com.cn.springthreadpool.entity.Page;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 数据库消息定期检查任务，异常情况时将数据修复
 * @version 创建时间：2019/2/19
 */
@Slf4j
public class DBMessageCheckTask implements Runnable {

	private StringRedisTemplate stringRedisTemplate;

	private ScheduledExecutorService scheduledExecutorService;

	private PushMessageService pushMessageService;

	private TaskConfig taskConfig;

	public DBMessageCheckTask(TaskConfig taskConfig){
		this.taskConfig=taskConfig;
		this.stringRedisTemplate=taskConfig.getStringRedisTemplate();
		this.scheduledExecutorService=taskConfig.getScheduledExecutorService();
		this.pushMessageService=taskConfig.getPushMessageService();
	}

	public static void main(String[] args) {
		QueryDto dto=new QueryDto().setPageNum(1).setPageSize(1000).setStatus(MessageStatusEnum.PROCESSING);
		System.out.println(dto.getStatus());
	}

	/**
	 * 定期检查数据库中已标记为执行中的消息是否已存在于redis中，如不存在，则将消息重新加入redis。
	 * 避免异常情况下，db中消息已标记为执行中，但redis队列中消息丢失，导致消息遗漏
	 */
	@Override
	public void run() {
		try {
			//扫描数据库中状态为1的消息，检查uuid对应的key是否存在，如不存在，则创建定时任务和redis key
			Page<PushMessage> page=pushMessageService.pagedQuery(new QueryDto().setPageNum(1).setPageSize(1000).setStatus(MessageStatusEnum.PROCESSING));
			log.debug("定时扫描数据库进行中消息，共{}条，当前查询{}条",page.getTotalCount(),page.getList().size());
			List<PushMessage> pushMessageList=page.getList();
			for(PushMessage pushMessage:pushMessageList){
				String value=stringRedisTemplate.opsForValue().get(pushMessage.getUuid());

				if(value==null){
					log.debug("消息[{}]丢失或超时，重新加入发送队列",pushMessage.getUuid());
					stringRedisTemplate.opsForValue().set(TaskConstant.MESSAGE_KEY_PREFIX+pushMessage.getUuid(),pushMessage.getUuid(),60*30*10,TimeUnit.SECONDS);
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
			}
		}catch (Exception e){
			log.error("数据检验任务异常:",e);
		}
	}

}
