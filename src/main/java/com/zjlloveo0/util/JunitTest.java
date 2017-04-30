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
import com.zjlloveo0.model.Server;
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
//		String s="[{\"id\":\"1\",\"createrId\":\"1\",\"createTime\":\"Sun Jan 01 00:00:00 CST 2017\",\"title\":\"装系统\",\"content\":\"电脑系统\",\"img\":\"img/null.jpg\",\"exchangePoint\":\"10\",\"isEnable\":\"1\",\"updateTime\":\"Thu Mar 30 10:03:18 CST 2017\"}, {\"id\":\"2\",\"createrId\":\"2\",\"createTime\":\"Thu Mar 30 23:06:54 CST 2017\",\"title\":\"清灰\",\"content\":\"电脑清灰\",\"img\":\"null\",\"exchangePoint\":\"20\",\"isEnable\":\"1\",\"updateTime\":\"Thu Mar 30 23:07:31 CST 2017\"}]";
//		try {
//			JSONArray c=new JSONArray(s);
//			c.getJSONObject(0);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String addr = InetAddress.getLocalHost().getHostAddress();
//		System.out.println(addr);
		UserSchool currentUser=new UserSchool();
		
		JSONObject jsonObj=new JSONObject("{\"id\":51,\"name\":\"弄\",\"phone\":\"13253370006\",\"password\":\"11111q\",\"img\":\"null\",\"stuNum\":\"null\",\"point\":null,\"collegeId\":null,\"star\":null,\"isEnable\":1,\"updateTime\":\"Mon Apr 10 22:47:27 CST 2017\",\"schoolName\":\"null\",\"collegeName\":\"null\",\"createMissionNum\":0,\"createServerNum\":0}");
        currentUser=new UserSchool();
        String id=jsonObj.getString("id");
        String point=jsonObj.getString("point");
        String collegeId=jsonObj.getString("collegeId");
        String star=jsonObj.getString("star");
        String isEnable=jsonObj.getString("isEnable");
        String createMissionNum=jsonObj.getString("createMissionNum");
        String createServerNum=jsonObj.getString("createServerNum");
        
        currentUser.setId(id.equals("null")?null:Integer.valueOf(id));
        currentUser.setPoint(point.equals("null")?null:Integer.valueOf(point));
        currentUser.setCollegeId(collegeId.equals("null")?null:Integer.valueOf(collegeId));
        currentUser.setStar(star.equals("null")?null:Integer.valueOf(star));
        currentUser.setIsEnable(isEnable.equals("null")?null:Integer.valueOf(isEnable));
        currentUser.setCreateMissionNum(createMissionNum.equals("null")?null:Integer.valueOf(createMissionNum));
        currentUser.setCreateServerNum(createServerNum.equals("null")?null:Integer.valueOf(createServerNum));
        int i=1;
        i+=1;
	}
}

