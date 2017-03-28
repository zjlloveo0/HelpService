package com.zjlloveo0.model;

import java.util.Date;

public class College {
	private Integer id;
	private String schoolName;
	private String collegeName;
	private Integer isEnable;
	private Date updateTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
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
		return "{\"id\":\"" + id + "\",\"schoolName\":\"" + schoolName
				+ "\",\"collegeName\":\"" + collegeName + "\",\"isEnable\":\""
				+ isEnable + "\",\"updateTime\":\"" + updateTime + "\"}";
	}
}
