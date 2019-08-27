package com.cn.springthreadpool.entity;

/**
 * @version 创建时间：2019/2/19
 */
public enum MessageStatusEnum {
	NEW(0,"新增"),
	PROCESSING(1,"进行中"),
	SUCCESS(2,"成功"),
	CANCEL(3,"取消");

	private Integer value;
	private String desc;

	MessageStatusEnum(int value, String desc){
		this.value=value;
		this.desc=desc;
	}

	public Integer value(){
		return this.value;
	}

	public String desc(){
		return this.desc;
	}

	public static String desc(int value){
		for(MessageStatusEnum status:MessageStatusEnum.values()){
			if(status.value()==value){
				return status.desc();
			}
		}

		return null;
	}

}
