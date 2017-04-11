package com.zjlloveo0.service;

import java.util.List;

import com.zjlloveo0.model.Server;

public interface ServerService {
	String addServer(Server server);
	List<Server> findServer(Server server);
}
