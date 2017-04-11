package com.zjlloveo0.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlloveo0.dao.UserSchoolDAO;
import com.zjlloveo0.model.User;
import com.zjlloveo0.model.UserSchool;
import com.zjlloveo0.service.UserSchoolService;
 
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public class UserSchoolServiceImpl implements UserSchoolService{
 
    @Autowired
    @Qualifier("userSchoolDAO")
    private UserSchoolDAO userSchoolDAO;
    
	public List<UserSchool> findUserSchool(User user) {
		List<UserSchool> userList=userSchoolDAO.findUserSchool(user);
		return userList;
	}
}