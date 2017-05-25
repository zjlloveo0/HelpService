package com.zjlloveo0.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlloveo0.dao.MissionUserDAO;
import com.zjlloveo0.model.Mission;
import com.zjlloveo0.model.MissionUser;
import com.zjlloveo0.service.MissionUserService;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public class MissionUserServiceImpl implements MissionUserService {
	@Autowired
    @Qualifier("missionUserDAO")
    private MissionUserDAO missionUserDAO;
	
	public List<MissionUser> findMissionUser(Mission mission) {
		List<MissionUser> missionUserList=missionUserDAO.findMissionUser(mission);
		return missionUserList;
	}

}
