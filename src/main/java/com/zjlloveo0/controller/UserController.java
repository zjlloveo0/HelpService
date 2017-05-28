package com.zjlloveo0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjlloveo0.model.Msg;
import com.zjlloveo0.model.User;
import com.zjlloveo0.service.UserSchoolService;
import com.zjlloveo0.service.UserService;
import com.zjlloveo0.util.SYSVALUE;
 
@Controller
public class UserController {
 
	@Autowired
	private UserService userService;
	@Autowired
	private UserSchoolService userSchoolService;
	
    @RequestMapping(value="index",produces = "text/plain;charset=utf-8")
    public ModelAndView index(User user){
    	List <User> uList=userService.findUser(user);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("adminuser");
        mav.addObject("uList",uList);
        return mav;
    }
//    @ResponseBody
//    @RequestMapping(value="login",produces = "text/plain;charset=utf-8")
//    public String login(User user){
//    	if(user==null||user.getPhone()==null||"".equals(user.getPhone())
//    			||user.getPassword()==null||"".equals(user.getPassword())){
//    		return new Msg(112, SYSVALUE.MESSAGE.get("E_USER_LESS_FIELD"))
//			.toString();
//    	}
//    	User u=new User();//保证只传手机号、密码
//    	u.setPhone(user.getPhone());
//    	u.setPassword(user.getPassword());
//    	List<User> res=userService.findUser(u);
//    	if(res.size()==1){
//    		return new Msg(201,res.get(0).toString()).toString();
//    	}else if(res.size()==0){
//    		return new Msg(106,SYSVALUE.MESSAGE.get("E_LOGIN_NOTEXIST")).toString();
//    	}else{
//    		return new Msg(107,SYSVALUE.MESSAGE.get("E_LOGIN_EXCEPTION")).toString();
//    	}
//    }
    @ResponseBody
    @RequestMapping(value="reg",produces = "text/plain;charset=utf-8")
    public String register(User user){
    	if(user==null||user.getPhone()==null||"".equals(user.getPhone())
    			||user.getPassword()==null||"".equals(user.getPassword())
    			||user.getName()==null||"".equals(user.getName())){
    		return new Msg(112, SYSVALUE.MESSAGE.get("E_USER_LESS_FIELD"))
			.toString();
    	}
    	if(!user.getPhone().matches(SYSVALUE.REGEX_PHONE)){
    		return new Msg(104,SYSVALUE.MESSAGE.get("E_CHECK_PHONE")).toString();
    	}
    	if(!user.getPassword().matches(SYSVALUE.REGEX_PASSWORD)){
    		return new Msg(105,SYSVALUE.MESSAGE.get("E_CHECK_PASSWORD")).toString();
    	}
    	user.setIsEnable(1);
        return userService.registertUser(user);
    }
    @ResponseBody
    @RequestMapping(value="findUser",produces = "text/plain;charset=utf-8")
    public String findUser(User user){
    	List<User> userList=userService.findUser(user);
   		return new Msg(userList.size(),userList.toString()).toString();
    }
    @ResponseBody
    @RequestMapping(value="updateUser",produces = "text/plain;charset=utf-8")
    public String updateUser(User user){
    	if(user==null||user.getId()==null||user.getId()==0){
    		return new Msg(112, SYSVALUE.MESSAGE.get("E_USER_LESS_FIELD")).toString();
    	}
    	return userService.updateUser(user);
    }
}
