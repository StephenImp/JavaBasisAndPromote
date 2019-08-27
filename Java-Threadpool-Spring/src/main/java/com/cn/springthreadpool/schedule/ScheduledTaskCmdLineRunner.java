package com.cn.springthreadpool.schedule;

import com.cn.springthreadpool.config.TaskConfig;
import com.cn.springthreadpool.entity.SysModeEnum;
import com.cn.springthreadpool.service.PushMessageService;
import com.cn.springthreadpool.task.DBMessageCheckTask;
import com.cn.springthreadpool.task.DBMessageScanTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务启动类
 * @author wpw
 * @version 创建时间：2019/8/27
 */
@Slf4j
@Component
public class ScheduledTaskCmdLineRunner implements CommandLineRunner {

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private PushMessageService pushMessageService;

	@Value("${system.switch:normal}")
	private String mode;

	@Value("${system.url}")
	private String url;

	@Value("${system.secret}")
	private String secret;

	private TaskConfig taskConfig=new TaskConfig();

	@Override
	public void run(String... var1) throws Exception{
		if(mode.equals(SysModeEnum.DISABLE.val())){
			log.warn("当前消息推送模式为[{}]，终止启动定时任务", SysModeEnum.DISABLE.getDesc());
			return;
		}else if(mode.equals(SysModeEnum.MAINTAIN.val())){
			log.info("当前消息推送模式为[{}]",SysModeEnum.MAINTAIN.getDesc());
		}

		log.info("启动定时任务");

		//数据库scan/check任务和消息发送任务使用不同的线程池，避免消息发送任务超过corePoolSize导致数据库scan/check任务无法按时执行
		//数据库scan/check任务使用单线程线程池，串行处理
		ScheduledExecutorService periodTaskThreadPool = Executors.newSingleThreadScheduledExecutor();
		ScheduledExecutorService oneTimeTaskThreadPool = Executors.newScheduledThreadPool(10);

		/**
		 * 线程中使用@Resource或者@Autowired注入全部为NULL，
		 * Spring不能在线程中注入。
		 */
		taskConfig.setScheduledExecutorService(oneTimeTaskThreadPool);
		taskConfig.setPushMessageService(pushMessageService);
		taskConfig.setStringRedisTemplate(stringRedisTemplate);
		taskConfig.setRestTemplate(restTemplate);
		taskConfig.setUrl(url);
		taskConfig.setSecret(secret);

		//扫描数据库需要
		DBMessageScanTask dbMessageScanTask=new DBMessageScanTask(taskConfig);
		DBMessageCheckTask dbMessageCheckTask=new DBMessageCheckTask(taskConfig);

		periodTaskThreadPool.scheduleWithFixedDelay(dbMessageScanTask, 30, 5, TimeUnit.SECONDS);
		periodTaskThreadPool.scheduleWithFixedDelay(dbMessageCheckTask, 30, 5, TimeUnit.SECONDS);
	}

}

