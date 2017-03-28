package com.zjlloveo0.util;

import java.util.HashMap;

import com.zjlloveo0.model.Msg;

public class SYSVALUE {
	//系统参数
	public final static String APPKEY="407df2982f45018bda4e71427504c174"; 
	public final static String APPSECRET="350dcd837969"; 
	public final static String CONTENTTYPE="application/x-www-form-urlencoded;charset=utf-8"; 
	//URL
	public final static String URL_CREATEUSER="https://api.netease.im/nimserver/user/create.action";
	
	public final static HashMap<String,Msg> MESSAGE=new HashMap<String, Msg>();
	//初始化参数
	static{
		//E开头成功类
		//S开头失败类
		MESSAGE.put("E_POST", new Msg(100,"POST异常！"));
		MESSAGE.put("E_SYSTEM", new Msg(101,"系统异常！"));
	}
}
