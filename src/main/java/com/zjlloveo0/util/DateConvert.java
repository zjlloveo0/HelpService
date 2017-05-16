package com.zjlloveo0.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String stringDate) {
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

}