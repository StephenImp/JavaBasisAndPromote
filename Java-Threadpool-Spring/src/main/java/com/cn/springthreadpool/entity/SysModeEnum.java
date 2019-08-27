package com.cn.springthreadpool.entity;

/**
 * @author wpw
 * @version 创建时间：2019/5/14
 */
public enum SysModeEnum {

	NORMAL("normal","正常"),
	MAINTAIN("maintain","维护模式"),
	DISABLE("disable","禁用")
	;

	private String mode;

	private String desc;

	SysModeEnum(String mode, String desc){
		this.mode=mode;
		this.desc=desc;
	}

	public String val() {
		return mode;
	}

	public String getDesc() {
		return desc;
	}

}
