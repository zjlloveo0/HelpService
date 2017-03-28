package com.zjlloveo0.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import com.zjlloveo0.dao.UserDAO;
import com.zjlloveo0.model.User;
import com.zjlloveo0.service.UserService;
import com.zjlloveo0.util.HttpTools;
import com.zjlloveo0.util.SYSVALUE;
 
 
 
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public class UserServiceImpl implements UserService{
 
    @Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO;
//    @Transactional(rollbackFor=Exception.class)
    public int insertUser(User user) {
    	int res=0;
    	
//    	try {
    		res=userDAO.insertUser(user);
			int i=1/0;
			res+=userDAO.insertUser(user);
//			String result=HttpTools.sendPost(SYSVALUE.URL_CREATEUSER, "accid="+user.getPhone()+"&name="+user.getName()+"&icon="+user.getImg()+"&token="+user.getPassword());
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
    	System.out.println(res);
    	
        return res;
    }
//    @Transactional(rollbackFor=Exception.class)
	public User findUserById(int i) {
		User u=userDAO.findUserById(i);
		System.out.println("**************");
		User e=userDAO.findUserById(i);
		return u;
	}
 
}