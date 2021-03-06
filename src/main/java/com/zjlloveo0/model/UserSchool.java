package com.zjlloveo0.model;

import com.zjlloveo0.util.JsonTools;

public class UserSchool extends User{
	private String schoolName;
	private String collegeName;
	private Integer createMissionNum;
	private Integer createServerNum;

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

	public Integer getCreateMissionNum() {
		return createMissionNum;
	}

	public void setCreateMissionNum(Integer createMissionNum) {
		this.createMissionNum = createMissionNum;
	}

	public Integer getCreateServerNum() {
		return createServerNum;
	}

	public void setCreateServerNum(Integer createServerNum) {
		this.createServerNum = createServerNum;
	}

	@Override
	public String toString() {
		return "{\"id\":" + getId() + ",\"name\":\"" + getName()+"\",\"schoolInfo\":\""+getSchoolInfo()
				+ "\",\"phone\":\"" + getPhone() + "\",\"password\":\""
				+ getPassword() + "\",\"img\":\"" + getImg()
				+ "\",\"stuNum\":\"" + getStuNum() + "\",\"point\":"
				+ getPoint() + ",\"collegeId\":" + getCollegeId()
				+ ",\"star\":" + getStar() + ",\"isEnable\":" + getIsEnable()
				+ ",\"updateTime\":\"" + JsonTools.formatDate(getUpdateTime()) 
				+ "\",\"schoolName\":\"" + schoolName + "\",\"collegeName\":\""
				+ collegeName + "\",\"createMissionNum\":" + createMissionNum
				+ ",\"createServerNum\":" + createServerNum + "}";
	}

}
