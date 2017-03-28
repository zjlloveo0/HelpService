package com.zjlloveo0.dao;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlloveo0.model.User;
//@Transactional
//(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public interface UserDAO {
	public int insertUser(User user);
	public User findUserById(int s);
}
