package com.cn.springthreadpool.task;

import com.alibaba.fastjson.JSONObject;
import com.cn.springthreadpool.config.TaskConfig;
import com.cn.springthreadpool.entity.*;
import com.cn.springthreadpool.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 数据库定时扫描任务
 *
 * @version 创建时间：2019/2/19
 */
@Slf4j
public class DBMessageScanTask implements Runnable {

	private StringRedisTemplate stringRedisTemplate;

	private ScheduledExecutorService scheduledExecutorService;

	private PushMessageService pushMessageService;

	private TaskConfig taskConfig;

	public DBMessageScanTask(TaskConfig taskConfig) {
		this.taskConfig = taskConfig;
		this.stringRedisTemplate = taskConfig.getStringRedisTemplate();
		this.scheduledExecutorService = taskConfig.getScheduledExecutorService();
		this.pushMessageService=taskConfig.getPushMessageService();
	}

	/**
	 * 定时扫描数据库，将所有新增状态的消息加入redis队列中，更新消息状态
	 */
	@Override
	public void run() {
		try {
			//扫描数据库中状态为0的消息，为每个消息创建一次性定时任务，将消息状态修改为1，并将消息uuid作为key存入redis，设置有效期
			Page<PushMessage> page = pushMessageService.pagedQuery(new QueryDto().setPageNum(1).setPageSize(1000).setStatus(MessageStatusEnum.NEW));
			log.debug("定时扫描数据库新增消息，共{}条，当前查询{}条", page.getTotalCount(), page.getList().size());
			List<PushMessage> pushMessageList = page.getList();
			for (PushMessage pushMessage : pushMessageList) {

				log.debug("推送的消息内容为：[{}]@@@@@@@@@@@@@@@@@@@@@@@@", JSONObject.toJSONString(pushMessage));

				stringRedisTemplate.opsForValue().set(TaskConstant.MESSAGE_KEY_PREFIX + pushMessage.getUuid(), pushMessage.getUuid(), 10*60*30, TimeUnit.SECONDS);
				MessagePushTask messagePushTask = new MessagePushTask(pushMessage, taskConfig);
				//下次发送时间间隔
				int delaySeconds = 10;

				log.debug("delaySeconds时间间隔[{}]",delaySeconds);
				log.debug("发送次数[{}]", pushMessage.getTryCount() + 1);
				log.debug("发送类型[{}]", pushMessage.getType());
				log.debug("消息uuid[{}]", pushMessage.getUuid());

				try {
					log.debug("计划{}秒后第{}次推送{}消息[{}]", delaySeconds, pushMessage.getTryCount() + 1, pushMessage.getType(), pushMessage.getUuid());
					scheduledExecutorService.schedule(messagePushTask, delaySeconds, TimeUnit.SECONDS);

					pushMessage.setStatus(MessageStatusEnum.PROCESSING);
					pushMessageService.updateMessage(pushMessage);

				}catch (Exception e){
					log.info("消息推送异常[{}]",e.getMessage());
				}

			}
		}catch (Exception e){
			log.error("数据库扫描任务异常:",e);
		}
	}

}
