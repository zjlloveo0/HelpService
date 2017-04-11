package com.zjlloveo0.dao;

import java.util.List;

import com.zjlloveo0.model.User;
import com.zjlloveo0.model.UserSchool;

public interface UserSchoolDAO {
	public List<UserSchool> findUserSchool(User user);
}
