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
import com.zjlloveo0.dao.UserDAO;
import com.zjlloveo0.model.Mission;
import com.zjlloveo0.model.Msg;
import com.zjlloveo0.model.User;
import com.zjlloveo0.service.MissionService;
import com.zjlloveo0.util.MiPush;
import com.zjlloveo0.util.SYSVALUE;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public class MissionServiceImpl implements MissionService {
	@Autowired
    @Qualifier("missionDAO")
    private MissionDAO missionDAO;
	@Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO;
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

	@Override
	public String updateMission(Mission mission) {
		int updateU1=-1;
		int updateU2=-1;
		int updateM=-1;
		
		Mission m=new Mission();
		m.setId(mission.getId());
		List<Mission> mList=findMission(m);
		if(mList.size()<1||mList.get(0).getIsEnable()==0){
			return new Msg(116,SYSVALUE.MESSAGE.get("E_MISSION_NO_EXIST")).toString();
		}
		Mission mi=mList.get(0);
		Integer changeState=mission.getState();
		if(changeState!=null){
			switch(mi.getState()){
				case 0:
	//				s="暂无人接任务";
					if(changeState!=1){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
					break;
				case 1:
	//				s="正在完成任务";
					if(changeState!=2&&changeState!=4&&changeState!=5){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
					break;
				case 2:
	//				s="任务已完成";
					if(changeState!=3){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
					break;
				case 3:
	//				s="任务已结束";
		        	return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
				case 4:
	//				s="任务接受者终止订单";
					if(changeState!=0){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
					break;
				case 5:
	//				s="任务发布者终止订单";
					if(changeState!=0){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
					break;
				default:
	//				s="状态异常";
		        	return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
			}
			if(changeState==3){
				User u1=new User();
				u1.setId(mi.getCreaterId());
				List<User> uL1=userDAO.findUser(u1);
				User u2=new User();
				u2.setId(mi.getReceiverId());
				List<User> uL2=userDAO.findUser(u2);
				if(uL1.size()==1&&uL2.size()==1){
					u1=uL1.get(0);
					u2=uL2.get(0);
					User uu1=new User();
					User uu2=new User();
					uu1.setId(u1.getId());
					uu1.setPoint((u1.getPoint()==null?0:u1.getPoint())-(mi.getExchangePoint()==null?0:mi.getExchangePoint()));
					uu2.setId(u2.getId());
					uu2.setPoint((u2.getPoint()==null?0:u2.getPoint())+(mi.getExchangePoint()==null?0:mi.getExchangePoint()));
					try {
						if(uu1.getPoint()<=SYSVALUE.POINT_MIN){
							MiPush.sendMessageToAlias("积分余额不足", "您的积分余额已不足"+SYSVALUE.POINT_MIN+"分，为避免系统停用您的账户，请尽快通过充值或帮别人完成任务来获取积分", u1.getName()+",您的积分余额已不足，请尽快获取积分", u1.getId()+"",0,"","");
						}
						if(uu2.getPoint()<=SYSVALUE.POINT_MIN){
							MiPush.sendMessageToAlias("积分余额不足", "您的积分余额已不足"+SYSVALUE.POINT_MIN+"分，为避免系统停用您的账户，请尽快通过充值或帮别人完成任务来获取积分", u2.getName()+",您的积分余额已不足，请尽快获取积分", u2.getId()+"",0,"","");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					updateU1=userDAO.updateUser(uu1);
					updateU2=userDAO.updateUser(uu2);
					if(!(updateU1==1&&updateU2==1)){
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return new Msg(401,SYSVALUE.MESSAGE.get("T_FAIL")).toString();
					}
				}else{
					return new Msg(401,SYSVALUE.MESSAGE.get("T_FAIL")).toString();
				}
			}
		}
		updateM=missionDAO.updateMission(mission);
		if(updateM==1){
			try {
				MiPush.sendMessageToAlias("任务进度更新", mi.getId()+"", "您的任务\""+mi.getTitle()+"\"进度有更新，点击查看", mi.getCreaterId()+"",0,"","");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new Msg(400,SYSVALUE.MESSAGE.get("T_SUCCESS")).toString();
		}else{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return new Msg(401,SYSVALUE.MESSAGE.get("T_FAIL")).toString();
		}
	}

}
