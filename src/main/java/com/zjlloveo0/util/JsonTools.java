package com.zjlloveo0.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import com.zjlloveo0.model.Msg;

public class JsonTools {  
    public static String getValue(String json,String Key){
    	
    	return "";
    }
    public static JSONObject toJsonObject(String s){
    	
    	return null;
    }
    public static String formatDate(Date date){
    	SimpleDateFormat sdf=new SimpleDateFormat(SYSVALUE.SDF);
    	if(date==null){
    		return "null";
    	}
    	return sdf.format(date);
    }
    public static Date convert(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SYSVALUE.SDF);
        try {
        	if(!(stringDate==null||stringDate.equals("")||stringDate.equals("null"))){
        		return simpleDateFormat.parse(stringDate);
        	}else{
        		return null;
        	}
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean isNull(String s){
		return (s==null||"".equals(s));
    }
} 