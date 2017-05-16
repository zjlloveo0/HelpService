package com.zjlloveo0.dao;

import java.util.List;

import com.zjlloveo0.model.Mission;

public interface MissionDAO {
	public int insertMission(Mission mission);
	public int updateMission(Mission mission);
	public List<Mission> findMission(Mission mission);
}
