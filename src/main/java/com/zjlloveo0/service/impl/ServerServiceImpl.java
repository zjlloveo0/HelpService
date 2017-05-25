package com.zjlloveo0.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.zjlloveo0.dao.ServerDAO;
import com.zjlloveo0.model.Msg;
import com.zjlloveo0.model.Server;
import com.zjlloveo0.service.ServerService;
import com.zjlloveo0.util.SYSVALUE;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public class ServerServiceImpl implements ServerService {
	@Autowired
    @Qualifier("serverDAO")
    private ServerDAO serverDAO;
	
	public String addServer(Server server) {
		int dbResult=-1;
		String rqstResult="";
		
		try{
			//查询是否存在同用户发布的完全相同的服务
			Server ser=new Server();
			ser.setCreaterId(server.getCreaterId());
			ser.setTitle(server.getTitle());
			if(serverDAO.findServer(ser).size()>0){
				rqstResult=new Msg(108,SYSVALUE.MESSAGE.get("E_SERVER_EXIST")).toString();
				dbResult=0;
				throw new RuntimeException(SYSVALUE.MESSAGE.get("E_SERVER_EXIST"));
			}
			//插入
			dbResult=serverDAO.insertServer(server);
			if(dbResult!=1){
				rqstResult=new Msg(103,SYSVALUE.MESSAGE.get("E_SYSTEM")).toString();
				throw new RuntimeException(SYSVALUE.MESSAGE.get("E_SYSTEM"));
			}else{
				rqstResult=new Msg(202,SYSVALUE.MESSAGE.get("S_CREATE_SERVER")).toString();
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

	public List<Server> findServer(Server server) {
		List<Server> serList=serverDAO.findServer(server);
		return serList;
	}

	@Override
	public String updateServer(Server server) {
		int dbResult=-1;
		String rqstResult="";
		
		try{
			//查询是否存在同用户发布的完全相同的服务
			Server ser=new Server();
			ser.setCreaterId(server.getCreaterId());
			ser.setTitle(server.getTitle());
			List<Server> ls=serverDAO.findServer(ser);
			if(ls.size()>0&&ls.get(0).getCreaterId()==ser.getCreaterId()){
				rqstResult=new Msg(108,SYSVALUE.MESSAGE.get("E_SERVER_EXIST")).toString();
				dbResult=0;
				throw new RuntimeException(SYSVALUE.MESSAGE.get("E_SERVER_EXIST"));
			}
			//插入
			dbResult=serverDAO.updateServer(server);
			if(dbResult!=1){
				rqstResult=new Msg(103,SYSVALUE.MESSAGE.get("E_SYSTEM")).toString();
				throw new RuntimeException(SYSVALUE.MESSAGE.get("E_SYSTEM"));
			}else{
				rqstResult=new Msg(207,SYSVALUE.MESSAGE.get("S_UPDATE_SERVER")).toString();
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

}
