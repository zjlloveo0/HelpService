package com.zjlloveo0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjlloveo0.model.Msg;
import com.zjlloveo0.model.User;
import com.zjlloveo0.model.UserSchool;
import com.zjlloveo0.service.UserSchoolService;
import com.zjlloveo0.service.UserService;
import com.zjlloveo0.util.SYSVALUE;
 
@Controller
public class UserSchoolController {
 
	@Autowired
	private UserSchoolService userSchoolService;
	
    @ResponseBody
    @RequestMapping(value="login",produces = "text/plain;charset=utf-8")
    public String login(User user){
    	if(user==null||user.getPhone()==null||"".equals(user.getPhone())
    			||user.getPassword()==null||"".equals(user.getPassword())){
    		return new Msg(112, SYSVALUE.MESSAGE.get("E_USER_LESS_FIELD"))
			.toString();
    	}
    	User u=new User();//保证只传手机号、密码
    	u.setPhone(user.getPhone());
    	u.setPassword(user.getPassword());
    	u.setIsEnable(1);
    	List<UserSchool> res=userSchoolService.findUserSchool(u);
    	if(res.size()==1){
    		return new Msg(201,res.get(0).toString()).toString();
    	}else if(res.size()==0){
    		return new Msg(106,SYSVALUE.MESSAGE.get("E_LOGIN_NOTEXIST")).toString();
    	}else{
    		return new Msg(107,SYSVALUE.MESSAGE.get("E_LOGIN_EXCEPTION")).toString();
    	}
    }
}