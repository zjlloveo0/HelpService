package com.zjlloveo0.service;

import java.util.List;

import com.zjlloveo0.model.Mission;
import com.zjlloveo0.model.MissionUser;

public interface MissionUserService {
	List<MissionUser> findMissionUser(Mission mission);
}
