package com.zjlloveo0.util;

import java.util.HashMap;

public class SYSVALUE {
	//系统参数
	public final static String APPKEY="407df2982f45018bda4e71427504c174"; 
	public final static String APPSECRET="350dcd837969"; 
	public final static String CONTENTTYPE="application/x-www-form-urlencoded;charset=utf-8"; 
	//URL
	public final static String URL_CREATEUSER="https://api.netease.im/nimserver/user/create.action";
	//正则表达式
	public final static String REGEX_PHONE="^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\\d{8}$";
	public final static String REGEX_PASSWORD="^(?![\\d]+$)(?![a-zA-Z]+$)(?![^\\da-zA-Z]+$).{6,20}$";
	//信息
	public final static HashMap<String,String> MESSAGE=new HashMap<String, String>();
	//初始化参数
	static{
		//E开头成功类
		//S开头失败类
		MESSAGE.put("E_POST_EXCEPTION","POST异常！");//100
		MESSAGE.put("E_POST_SYSTEM", "系统POST服务异常！");//101
		MESSAGE.put("E_USER_EXIST", "用户已存在！");//102
		MESSAGE.put("E_SYSTEM", "系统异常！");//103
		MESSAGE.put("E_CHECK_PHONE", "手机号格式错误！");//104
		MESSAGE.put("E_CHECK_PASSWORD", "密码格式错误！");//105
		MESSAGE.put("E_LOGIN_NOTEXIST", "账户不存在或密码不正确！");//106
		MESSAGE.put("E_LOGIN_EXCEPTION", "登录出现异常！");//107
		MESSAGE.put("E_SERVER_EXIST", "您已经发布过相同的服务！");//108
		MESSAGE.put("E_SERVER_LESS_FIELD", "您填写的服务信息不完整！");//109
		MESSAGE.put("E_MISSION_EXIST", "您已经发布过相同的任务！");//110
		MESSAGE.put("E_MISSION_LESS_FIELD", "您填写的任务信息不完整！");//111
		MESSAGE.put("E_USER_LESS_FIELD", "您填写的用户信息不完整！");//112
		MESSAGE.put("S_CREATE_USER", "创建用户成功！");//200
		MESSAGE.put("S_LOGIN", "登录成功！");//201
		MESSAGE.put("S_CREATE_SERVER", "服务发布成功！");//202
		MESSAGE.put("S_CREATE_MISSION", "任务发布成功！");//203
	}
}
