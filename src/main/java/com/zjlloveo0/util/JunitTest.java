package com.zjlloveo0.util;

import org.junit.Test;

import com.zjlloveo0.model.Msg;

public class JunitTest {
	@Test
	public void testSYSVALUE(){
		SYSVALUE.MESSAGE.get("TEST").toString();
	}
	@Test
	public void testHttpTools(){
		System.out.println(HttpTools.sendPost("", "wd=2016"));
	}
}
