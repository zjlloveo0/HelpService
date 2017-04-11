package com.zjlloveo0.dao;

import java.util.List;

import com.zjlloveo0.model.Server;

public interface ServerDAO {
	public int insertServer(Server server);
	public List<Server> findServer(Server server);
}
