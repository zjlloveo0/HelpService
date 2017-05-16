package com.zjlloveo0.model;

import com.zjlloveo0.util.JsonTools;

public class ServerUser extends Server {
	private String createrName;
	private String createrImg;
	private Integer createrPoint;
	
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

	public Integer getCreaterPoint() {
		return createrPoint;
	}

	public void setCreaterPoint(Integer createrPoint) {
		this.createrPoint = createrPoint;
	}

	@Override
	public String toString() {
		return "{\"createrName\":\"" + createrName + "\",\"createrImg\":\"" + createrImg
				+ "\",\"createrPoint\":"+createrPoint+",\"id\":" + getId() + ",\"createrId\":"
				+ getCreaterId() + ",\"createTime\":\""
				+ JsonTools.formatDate(getCreateTime()) + "\",\"title\":\"" + getTitle()
				+ "\",\"content\":\"" + getContent()
				+ "\",\"exchangePoint\":" + getExchangePoint()
				+ ",\"isEnable\":" + getIsEnable()
				+ ",\"updateTime\":\"" + JsonTools.formatDate(getUpdateTime()) + "\",\"img\":\""+getImg()+"\"}";
	}
	
}
