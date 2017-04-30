package com.zjlloveo0.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.zjlloveo0.model.MissionUser;
import com.zjlloveo0.model.Server;
import com.zjlloveo0.model.ServerUser;
import com.zjlloveo0.model.UserSchool;

public class JunitTest {
	@Test
	public void testSYSVALUE(){
//		SYSVALUE.MESSAGE.get("TEST").toString();
//		String ss="";
//		String[] s=ss.split(",");
//		for(int i=0;i<s.length;i++){
//			System.out.println(s[i]+":"+s[i].matches("^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$"));
//		}
		UserSchool u=new UserSchool();
		u.toString();
	}
	@Test
	public void testHttpTools() {
		String s=HttpTools.sendPost(SYSVALUE.URL_CREATEUSER, "accid=test1111");
		try {
			System.out.println(new JSONObject(s).getString("content"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testJson() throws UnknownHostException, JSONException {
		MissionUser s=new MissionUser();
		s.toString();
	}
}

