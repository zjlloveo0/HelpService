package com.zjlloveo0.dao;

import java.util.List;

import com.zjlloveo0.model.Server;
import com.zjlloveo0.model.ServerUser;

public interface ServerUserDAO{
	public List<ServerUser> findServerUser(Server server);
}
