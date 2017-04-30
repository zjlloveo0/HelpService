package com.zjlloveo0.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjlloveo0.model.Msg;
import com.zjlloveo0.model.Server;
import com.zjlloveo0.model.ServerUser;
import com.zjlloveo0.service.ServerService;
import com.zjlloveo0.service.ServerUserService;
import com.zjlloveo0.util.SYSVALUE;

@Controller
public class ServerController {

	@Autowired
	private ServerService serverService;
	@Autowired
	private ServerUserService serverUserService;

	@ResponseBody
	@RequestMapping(value = "createServer", produces = "text/plain;charset=utf-8")
	public String createServer(Server server) {
		if (server==null||server.getCreaterId() == null || server.getCreaterId() == 0
				|| server.getTitle() == null ||  "".equals(server.getTitle())
				|| server.getContent() == null||  "".equals(server.getContent())
				|| server.getExchangePoint() == null|| server.getExchangePoint() < 0) {
			return new Msg(109, SYSVALUE.MESSAGE.get("E_SERVER_LESS_FIELD"))
					.toString();
		}
		server.setCreateTime(new Date());
		server.setIsEnable(1);
		return serverService.addServer(server);
	}
	@ResponseBody
	@RequestMapping(value = "findServer", produces = "text/plain;charset=utf-8")
	public String findServer(Server server) {
		List<Server> serverList=serverService.findServer(server);
		return new Msg(serverList.size(),serverList.toString()).toString();
	}
	@ResponseBody
	@RequestMapping(value = "findServerUser", produces = "text/plain;charset=utf-8")
	public String findServerUser(Server server) {
		List<ServerUser> serverUserList=serverUserService.findServerUser(server);
		return new Msg(serverUserList.size(),serverUserList.toString()).toString();
	}
}