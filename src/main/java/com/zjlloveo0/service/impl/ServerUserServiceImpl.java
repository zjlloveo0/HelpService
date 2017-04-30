package com.zjlloveo0.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zjlloveo0.dao.ServerDAO;
import com.zjlloveo0.dao.ServerUserDAO;
import com.zjlloveo0.model.Msg;
import com.zjlloveo0.model.Server;
import com.zjlloveo0.model.ServerUser;
import com.zjlloveo0.service.ServerService;
import com.zjlloveo0.service.ServerUserService;
import com.zjlloveo0.util.SYSVALUE;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public class ServerUserServiceImpl implements ServerUserService {
	@Autowired
    @Qualifier("serverUserDAO")
    private ServerUserDAO serverUserDAO;

	public List<ServerUser> findServerUser(Server server) {
		List<ServerUser> serList=serverUserDAO.findServerUser(server);
		return serList;
	}

}
