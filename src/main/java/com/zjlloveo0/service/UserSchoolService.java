package com.zjlloveo0.service;

import java.util.List;

import com.zjlloveo0.model.User;
import com.zjlloveo0.model.UserSchool;

public interface UserSchoolService {
	List<UserSchool> findUserSchool(User user);
}
