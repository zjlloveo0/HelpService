package com.zjlloveo0.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjlloveo0.model.MissionUser;
import com.zjlloveo0.model.Msg;
import com.zjlloveo0.model.Mission;
import com.zjlloveo0.service.MissionService;
import com.zjlloveo0.service.MissionUserService;
import com.zjlloveo0.util.SYSVALUE;

@Controller
public class MissionController {

	@Autowired
	private MissionService missionService;
	@Autowired
	private MissionUserService missionUserService;

	@ResponseBody
	@RequestMapping(value = "createMission", produces = "text/plain;charset=utf-8")
	public String createMission(Mission mission) {
		if (mission==null||mission.getCreaterId() == null || mission.getCreaterId() == 0
				|| mission.getTitle() == null || "".equals(mission.getTitle())
				|| mission.getContent() == null|| "".equals(mission.getContent())
				|| mission.getExchangePoint() == null|| mission.getExchangePoint() < 0) {
			return new Msg(111, SYSVALUE.MESSAGE.get("E_MISSION_LESS_FIELD"))
					.toString();
		}
		mission.setCreateTime(new Date());
		mission.setIsEnable(1);
		return missionService.addMission(mission);
	}
	@ResponseBody
	@RequestMapping(value = "findMission", produces = "text/plain;charset=utf-8")
	public String findMission(Mission mission) {
		List<Mission> missionList=missionService.findMission(mission);
		return new Msg(missionList.size(),missionList.toString()).toString();
	}
	@ResponseBody
	@RequestMapping(value = "updateMission", produces = "text/plain;charset=utf-8")
	public String updateMission(Mission mission) {
		System.out.println(mission.toString());
		if (mission==null||mission.getId() == null || mission.getId() == 0){
			return new Msg(111, SYSVALUE.MESSAGE.get("E_MISSION_LESS_FIELD"))
			.toString();
		}
		return missionService.updateMission(mission);
	}
	@ResponseBody
	@RequestMapping(value = "findMissionUser", produces = "text/plain;charset=utf-8")
	public String findMissionUser(Mission mission) {
		List<MissionUser> missionUserList=missionUserService.findMissionUser(mission);
		return new Msg(missionUserList.size(),missionUserList.toString()).toString();
	}
}
