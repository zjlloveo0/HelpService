package com.zjlloveo0.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Random;

import com.zjlloveo0.model.Msg;

public class HttpTools {
	public static String sendPost(String url, String params) {
		System.out.println("----开始POST请求----\n请求路径\n"+url);
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性，请求头
			String curTime=new Date().getTime()+"";
			String randNum=new Random().nextInt(999999)+"";
			String checkSum=CheckSumBuilder.getCheckSum(SYSVALUE.APPSECRET, randNum, curTime);
			conn.addRequestProperty("AppKey", SYSVALUE.APPKEY);
			conn.addRequestProperty("Nonce", randNum);
			conn.addRequestProperty("CurTime", curTime);
			conn.addRequestProperty("CheckSum", checkSum);
			conn.setRequestProperty("Content-Type",SYSVALUE.CONTENTTYPE);
			System.out.println("请求头\n"+"AppKey="+SYSVALUE.APPKEY+"&Nonce="+randNum+"&CurTime="+curTime+"&CheckSum="+checkSum+"&Content-Type="+SYSVALUE.CONTENTTYPE);
			System.out.println("请求参数\n"+params);
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
			// 发送请求参数
			out.write(params);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			System.out.println("请求结果\n"+result);
			result=new Msg(200,result).toString();
		} catch (Exception e) {
			result=new Msg(100,SYSVALUE.MESSAGE.get("E_POST_EXCEPTION")).toString();
			e.printStackTrace();
		}finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				result=new Msg(101,SYSVALUE.MESSAGE.get("E_POST_SYSTEM")).toString();
				ex.printStackTrace();
			}
		}
		System.out.println("----结束POST请求----");
		return result;
	}
}
