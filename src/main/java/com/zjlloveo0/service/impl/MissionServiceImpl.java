package com.zjlloveo0.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.zjlloveo0.dao.MissionDAO;
import com.zjlloveo0.model.Mission;
import com.zjlloveo0.model.Msg;
import com.zjlloveo0.service.MissionService;
import com.zjlloveo0.util.SYSVALUE;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public class MissionServiceImpl implements MissionService {
	@Autowired
    @Qualifier("missionDAO")
    private MissionDAO missionDAO;
	
	public String addMission(Mission mission) {
		int dbResult=-1;
		String rqstResult="";
		
		try{
			//查询是否存在同用户发布的完全相同的服务
			Mission miss=new Mission();
			miss.setCreaterId(mission.getCreaterId());
			miss.setTitle(mission.getTitle());
			if(missionDAO.findMission(miss).size()>0){
				rqstResult=new Msg(110,SYSVALUE.MESSAGE.get("E_MISSION_EXIST")).toString();
				dbResult=0;
				throw new RuntimeException(SYSVALUE.MESSAGE.get("E_MISSION_EXIST"));
			}
			//插入
			dbResult=missionDAO.insertMission(mission);
			if(dbResult!=1){
				rqstResult=new Msg(103,SYSVALUE.MESSAGE.get("E_SYSTEM")).toString();
				throw new RuntimeException(SYSVALUE.MESSAGE.get("E_SYSTEM"));
			}else{
				rqstResult=new Msg(203,SYSVALUE.MESSAGE.get("S_CREATE_MISSION")).toString();
			}
		}catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}finally{
			if(dbResult==-1||rqstResult.equals("")){
				rqstResult=new Msg(103,SYSVALUE.MESSAGE.get("E_SYSTEM")).toString();
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		}
		return rqstResult;
	}

	public List<Mission> findMission(Mission mission) {
		List<Mission> missionList=missionDAO.findMission(mission);
		return missionList;
	}

}
