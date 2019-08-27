package com.cn.springthreadpool.config;


import com.cn.springthreadpool.service.PushMessageService;
import lombok.Data;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ScheduledExecutorService;

/**
 * @version 创建时间：2019/2/27
 */
@Data
public class TaskConfig {

	private StringRedisTemplate stringRedisTemplate;
	private ScheduledExecutorService scheduledExecutorService;
	private RestTemplate restTemplate;
	private PushMessageService pushMessageService;
	private String url;
	private String secret;
}
