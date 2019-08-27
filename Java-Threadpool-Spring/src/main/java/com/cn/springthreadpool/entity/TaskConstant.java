package com.cn.springthreadpool.entity;

/**
 * @version 创建时间：2019/2/22
 */
public class TaskConstant {

	//最大重试次数
	public static int MAX_TRY_COUNT=10;

	//消息重发时间间隔数组
	public static int[] DELAY_SECONDS_ARR=new int[]{10,30,60*5,60*10,60*30};

	//redis中消息key前缀
	public static String MESSAGE_KEY_PREFIX="message:";

	//redis 消息发送成功前缀
	public static String MESSAGE_SUC_PREFIX="suc:";

	//redis 消息发送总量前缀
	public static String MESSAGE_SUM_PREFIX="sum:";

}
