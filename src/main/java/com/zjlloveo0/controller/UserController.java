package com.zjlloveo0.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjlloveo0.model.User;
import com.zjlloveo0.service.UserService;
 
@Controller
public class UserController {
 
	@Autowired
	private UserService userService;
	
    @RequestMapping(value="index")
    public ModelAndView index(User user){
    	userService.insertUser(user);
        ModelAndView mav=new ModelAndView();
        mav.setViewName("index");
        mav.addObject("user",user);
        return mav;
    }
    @ResponseBody
    @RequestMapping(value="reg",produces = "text/plain;charset=utf-8")
    public String registerOrLogin(User user){
//    	user.setId(13);
    	user.setName("zjl");
    	user.setPassword("111111");
    	user.setPhone("13246565");
    	user.setImg("123");
    	user.setCollegeId(1);
    	user.setIsEnable(1);
    	user.setStar(5);
    	user.setStuNum("4554554");
    	user.setPoint(100);
    	int res = userService.insertUser(user);
		
//    	String result=HttpTools.sendPost(SYSVALUE.URL_CREATEUSER, "accid="+user.getPhone()+"&name="+user.getName()+"&icon="+user.getImg()+"&token="+user.getPassword());
//    	System.out.println(result);
        return user.toString()+res;
    }
    @RequestMapping(value="test")
    public String test(){
    	User user =new User();
    	user.setName("zjl");
//    	userService.findUserById(1);
    	return "";
    }
}