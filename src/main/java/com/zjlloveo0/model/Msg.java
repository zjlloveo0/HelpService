package com.zjlloveo0.model;

public class Msg {
	private Integer code;
	private String content;
	
	public Msg(Integer code, String content) {
		this.code = code;
		this.content = content;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		String s="";
		if(content.startsWith("{\"")){
			s="{\"code\":" + code + ",\"content\":" + content + "}";
			System.out.println("**结果**\n"+s+"\n**结果**");
		}else if(content.startsWith("[{\"")){
			s="{\"code\":" + code + ",\"content\":" + content + "}";
			System.out.println("**结果**\n"+s+"\n**结果**");
		}else{
			s="{\"code\":" + code + ",\"content\":\"" + content + "\"}";
			System.out.println("**信息**\n"+s+"\n**信息**");
		}
		return s;
	}
}
