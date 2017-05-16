package com.zjlloveo0.model;

import com.zjlloveo0.util.JsonTools;

public class MissionUser extends Mission {
	
	private String createrName;
	private String createrImg;
	private String receiverName;
	private String receiverImg;
	private Integer createrPoint;
	private Integer receiverPoint;
	
	public Integer getCreaterPoint() {
		return createrPoint;
	}

	public void setCreaterPoint(Integer createrPoint) {
		this.createrPoint = createrPoint;
	}

	public Integer getReceiverPoint() {
		return receiverPoint;
	}

	public void setReceiverPoint(Integer receiverPoint) {
		this.receiverPoint = receiverPoint;
	}
	
	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public String getCreaterImg() {
		return createrImg;
	}

	public void setCreaterImg(String createrImg) {
		this.createrImg = createrImg;
	}
	
	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverImg() {
		return receiverImg;
	}

	public void setReceiverImg(String receiverImg) {
		this.receiverImg = receiverImg;
	}

	@Override
	public String toString() {
		return "{\"createrName\":\"" + createrName + "\",\"createrImg\":\"" + createrImg
				+ "\",\"receiverName\":\""+receiverName+"\",\"receiverImg\":\"" + receiverImg
				+ "\",\"id\":" + getId()+",\"state\":"+getState() + ",\"createrId\":"
				+ getCreaterId() + ",\"receiverId\":"
				+ getReceiverId() + ",\"createTime\":\""
				+ JsonTools.formatDate(getCreateTime()) + "\",\"finishTime\":\""
				+ JsonTools.formatDate(getFinishTime()) + "\",\"title\":\"" + getTitle()
				+ "\",\"content\":\"" + getContent()
				+ "\",\"exchangePoint\":" + getExchangePoint()
				+ ",\"createrPoint\":" + getCreaterPoint()
				+ ",\"receiverPoint\":" + getReceiverPoint()
				+ ",\"isEnable\":" + getIsEnable()
				+ ",\"updateTime\":\"" + JsonTools.formatDate(getUpdateTime()) + "\",\"img\":\""+getImg()+"\"}";
	}

}
