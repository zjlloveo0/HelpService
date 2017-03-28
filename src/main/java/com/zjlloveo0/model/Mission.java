package com.zjlloveo0.model;

import java.util.Date;

public class Mission {
	private Integer id;
	private Integer createrId;
	private Integer receiverId;
	private Date createTime;
	private Date finishTime;
	private String title;
	private String content;
	private String img;
	private Integer exchangePoint;
	private Integer status;
	private Integer isEnable;
	private Date updateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCreaterId() {
		return createrId;
	}
	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}
	public Integer getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getExchangePoint() {
		return exchangePoint;
	}
	public void setExchangePoint(Integer exchangePoint) {
		this.exchangePoint = exchangePoint;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"createrId\":\"" + createrId
				+ "\",\"receiverId\":\"" + receiverId + "\",\"createTime\":\""
				+ createTime + "\",\"finishTime\":\"" + finishTime
				+ "\",\"title\":\"" + title + "\",\"content\":\"" + content
				+ "\",\"img\":\"" + img + "\",\"exchangePoint\":\""
				+ exchangePoint + "\",\"status\":\"" + status
				+ "\",\"isEnable\":\"" + isEnable + "\",\"updateTime\":\""
				+ updateTime + "\"}";
	}
}
