package com.cn.springthreadpool.entity;


import java.util.Date;

/**
 * @version 创建时间：2019/2/19
 */

public class PushMessage {

	private Integer id;

	private String uuid;

	private String type;//访问记录、订单

	//消息体
	private String body;

	private Date createAt;

	//最后重试时间
	private Date lastTryTime;

	//重试次数
	private Integer tryCount;

	//消息状态，0：新建，1：进行中（已加入发送队列，待发送），2：成功，3：取消
	private Integer status;

	private Integer pageNum;
	private Integer pageSize;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getLastTryTime() {
		return lastTryTime;
	}

	public void setLastTryTime(Date lastTryTime) {
		this.lastTryTime = lastTryTime;
	}

	public Integer getTryCount() {
		return tryCount;
	}

	public void setTryCount(Integer tryCount) {
		this.tryCount = tryCount;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setStatus(MessageStatusEnum statusEnum){
		this.status=statusEnum.value();
	}

}

