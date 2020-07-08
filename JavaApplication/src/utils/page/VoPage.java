package com.douyu.device.model.vo.res;

import lombok.Data;

import java.util.List;

@Data
public class VoPage<T> {
	
	private Integer total;
	private List<T> list;
	Integer pageNum;//当前页码
	Integer pageSize;//当前页码

}
