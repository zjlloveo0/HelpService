package com.zjlloveo0.dao;

import java.util.List;
import com.zjlloveo0.model.User;

public interface UserDAO {
	public int insertUser(User user);
	public int updateUser(User user);
	public List<User> findUser(User user);
}
