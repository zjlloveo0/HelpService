package com.zjlloveo0.dao;

import java.util.List;

import com.zjlloveo0.model.Mission;
import com.zjlloveo0.model.MissionUser;

public interface MissionUserDAO{
	public List<MissionUser> findMissionUser(Mission mission);
}
