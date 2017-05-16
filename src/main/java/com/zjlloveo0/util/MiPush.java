package com.zjlloveo0.util;

import com.xiaomi.push.sdk.ErrorCode;
import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;

public class MiPush {
	public void init() {
		Constants.useOfficial();
	}

	private Message buildMessage() throws Exception {
		String PACKAGENAME = "com.zjlloveo0.help";
		String messagePayload = "This is a message";
		String title = "notification title";
		String description = "notification description";
		Message message = new Message.Builder().title(title)
				.description(description).payload(messagePayload)
				.restrictedPackageName(PACKAGENAME).passThrough(0) // 消息使用透传方式1
				.notifyType(1) // 使用默认提示音提示
				.extra("flow_control", "4000") // 设置平滑推送, 推送速度4000每秒(qps=4000)
				.build();
		return message;
	}

	public static String sendMessageToAlias(String title,String msg,String desc,String alias,int passThrough,String key,String value) throws Exception {
		Constants.useOfficial();
		Sender sender = new Sender(SYSVALUE.MIAPPSECRET);
		Message.Builder builder=new Message.Builder();
		builder.title(title)
			.description(desc).payload(msg)
			.passThrough(passThrough)
			.restrictedPackageName(SYSVALUE.PACKAGENAME)
			.notifyType(1) // 使用默认提示音提示
			.build();
		if(key!=null&&value!=null){
			builder.extra(key, value);
		}
		Message message=builder.build();
		Result rs=null;
		if(alias==null){
			rs=sender.broadcastAll(message, 2);
		}else{
			rs=sender.sendToAlias(message, alias, 2);
		}
		if(rs.getErrorCode()==ErrorCode.Success){
			return "";
		}else{
			return rs.getReason();
		}
	}
}
