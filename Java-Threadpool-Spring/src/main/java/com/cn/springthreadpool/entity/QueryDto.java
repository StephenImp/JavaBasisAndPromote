package com.cn.springthreadpool.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @version 创建时间：2019/2/27
 */
@Data
@Accessors(chain = true)
public class QueryDto {
	private Integer status;
	private Integer pageNum;
	private Integer pageSize;

	public QueryDto setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public QueryDto setStatus(MessageStatusEnum statusEnum){
		this.status=statusEnum.value();
		return this;
	}

}
