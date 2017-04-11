package com.zjlloveo0.service;

import java.util.List;

import com.zjlloveo0.model.User;

public interface UserService {
	String registertUser(User user);
	List<User> findUser(User user);
}
