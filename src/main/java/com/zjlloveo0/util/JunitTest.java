package com.zjlloveo0.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.zjlloveo0.model.MissionUser;
import com.zjlloveo0.model.OrdersDetail;
import com.zjlloveo0.model.User;
import com.zjlloveo0.model.UserSchool;

public class JunitTest {
	@Test
	public void testSYSVALUE() throws Exception {
//		OrdersDetail orders = new OrdersDetail();
//		orders.setCreateUser(new UserSchool());
//		orders.setOfUser(new UserSchool());
//		orders.setId(1);
//		orders.setImg(null);
//		System.out.println(getParamters(orders));
		//(String title,String msg,String desc,String account) throws Exception {
		//14-58     13-57
//		String s=MiPush.sendMessageToAlias("REFRESH", "18", "SERVER_ORDERS_DETAIL", null,1,"TARGET","SERVER_ORDERS_DETAIL");
//		String s="zjl";
//		switch(s){
//			case "zjl":System.out.println(456);
//		}
		System.out.println(JsonTools.formatDate(new Date()));
	}

	public static String getParamters(Object o) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (o != null) {
			Field[] fields = o.getClass().getDeclaredFields();
			String fieldName;
			String firstLetter;
			String getter;
			for (int i = 0; i < fields.length; i++) {
				fieldName = fields[i].getName();
				firstLetter = fieldName.substring(0, 1).toUpperCase();
				getter = "get" + firstLetter + fieldName.substring(1);
				Method method = o.getClass().getMethod(getter, new Class[] {});
				Object value = method.invoke(o, new Object[] {});
				if (value != null && !"".equals(value.toString())) {
					if (sb.toString().equals("")) {
						sb.append("?");
					}else if(!sb.toString().equals("?")){
						sb.append("&");
					}
					sb.append(fieldName);
					sb.append("=");
					sb.append(value.toString());
				}
			}
		}
		return sb.toString();
	}

	private String[] getFiledName(Object o) throws Exception {
		try {
			Field[] fields = o.getClass().getDeclaredFields();
			String[] fieldNames = new String[fields.length];

			return fieldNames;
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 使用反射根据属性名称获取属性值
	 * 
	 * @param fieldName
	 *            属性名称
	 * @param o
	 *            操作对象
	 * @return Object 属性值
	 */

	private Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			System.out.println("属性不存在");
			return null;
		}
	}

	@Test
	public void testHttpTools() {
		String s = HttpTools
				.sendPost(SYSVALUE.URL_CREATEUSER, "accid=test1111");
		try {
			System.out.println(new JSONObject(s).getString("content"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testJson() throws UnknownHostException, JSONException {
		MissionUser s = new MissionUser();
		s.toString();
		// String
		// s="[{\"id\":\"1\",\"createrId\":\"1\",\"createTime\":\"Sun Jan 01 00:00:00 CST 2017\",\"title\":\"装系统\",\"content\":\"电脑系统\",\"img\":\"img/null.jpg\",\"exchangePoint\":\"10\",\"isEnable\":\"1\",\"updateTime\":\"Thu Mar 30 10:03:18 CST 2017\"}, {\"id\":\"2\",\"createrId\":\"2\",\"createTime\":\"Thu Mar 30 23:06:54 CST 2017\",\"title\":\"清灰\",\"content\":\"电脑清灰\",\"img\":\"null\",\"exchangePoint\":\"20\",\"isEnable\":\"1\",\"updateTime\":\"Thu Mar 30 23:07:31 CST 2017\"}]";
		// try {
		// JSONArray c=new JSONArray(s);
		// c.getJSONObject(0);
		// } catch (JSONException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// String addr = InetAddress.getLocalHost().getHostAddress();
		// System.out.println(addr);
		UserSchool currentUser = new UserSchool();

		JSONObject jsonObj = new JSONObject(
				"{\"id\":51,\"name\":\"弄\",\"phone\":\"13253370006\",\"password\":\"11111q\",\"img\":\"null\",\"stuNum\":\"null\",\"point\":null,\"collegeId\":null,\"star\":null,\"isEnable\":1,\"updateTime\":\"Mon Apr 10 22:47:27 CST 2017\",\"schoolName\":\"null\",\"collegeName\":\"null\",\"createMissionNum\":0,\"createServerNum\":0}");
		currentUser = new UserSchool();
		String id = jsonObj.getString("id");
		String point = jsonObj.getString("point");
		String collegeId = jsonObj.getString("collegeId");
		String star = jsonObj.getString("star");
		String isEnable = jsonObj.getString("isEnable");
		String createMissionNum = jsonObj.getString("createMissionNum");
		String createServerNum = jsonObj.getString("createServerNum");

		currentUser.setId(id.equals("null") ? null : Integer.valueOf(id));
		currentUser.setPoint(point.equals("null") ? null : Integer
				.valueOf(point));
		currentUser.setCollegeId(collegeId.equals("null") ? null : Integer
				.valueOf(collegeId));
		currentUser.setStar(star.equals("null") ? null : Integer.valueOf(star));
		currentUser.setIsEnable(isEnable.equals("null") ? null : Integer
				.valueOf(isEnable));
		currentUser.setCreateMissionNum(createMissionNum.equals("null") ? null
				: Integer.valueOf(createMissionNum));
		currentUser.setCreateServerNum(createServerNum.equals("null") ? null
				: Integer.valueOf(createServerNum));
		int i = 1;
		i += 1;
	}
}
