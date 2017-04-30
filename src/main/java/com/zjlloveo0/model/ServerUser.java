package com.zjlloveo0.model;

public class ServerUser extends Server {
	private static final long serialVersionUID = -6679540039631131864L;
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
				+ getCreateTime() + "\",\"title\":\"" + getTitle()
				+ "\",\"content\":\"" + getContent()
				+ "\",\"exchangePoint\":" + getExchangePoint()
				+ ",\"isEnable\":" + getIsEnable()
				+ ",\"updateTime\":\"" + getUpdateTime() + "\",\"img\":\""+getImg()+"\"}";
	}
	
}
