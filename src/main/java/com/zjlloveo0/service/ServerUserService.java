package com.zjlloveo0.service;

import java.util.List;

import com.zjlloveo0.model.Server;
import com.zjlloveo0.model.ServerUser;

public interface ServerUserService {
	List<ServerUser> findServerUser(Server server);
}
