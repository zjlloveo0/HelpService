package com.zjlloveo0.service;

import java.util.List;

import com.zjlloveo0.model.Mission;

public interface MissionService {
	String addMission(Mission mission);
	List<Mission> findMission(Mission mission);
}
