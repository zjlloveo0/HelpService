package com.zjlloveo0.service.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.zjlloveo0.dao.UserDAO;
import com.zjlloveo0.model.Msg;
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
    
    public String registertUser(User user) {
    	int dbResult=-1;
    	String postResult="";
    	
    	try {
    		User u=new User();
    		u.setPhone(user.getPhone());
    		if(findUser(u).size()!=0){
    			postResult=new Msg(102,SYSVALUE.MESSAGE.get("E_USER_EXIST")).toString();
    			dbResult=0;
    			throw new RuntimeException(SYSVALUE.MESSAGE.get("E_USER_EXIST"));
    		}
    		dbResult=userDAO.insertUser(user);
    		if(dbResult==1){
    			postResult=HttpTools.sendPost(SYSVALUE.URL_CREATEUSER, "accid="+user.getPhone()+"&name="+user.getName()+"&icon="+user.getImg()+"&token="+user.getPassword());
    		}else{
    			throw new RuntimeException();
    		}
    		if(!"".equals(postResult)){
    			JSONObject jsonRes=new JSONObject(postResult);
    			int code=jsonRes.getInt("code");
    			if(code==200){
    				JSONObject content=jsonRes.getJSONObject("content");
    				int nimCode=content.getInt("code");
    				if(nimCode!=200){
    					if(content.getString("desc").indexOf("already register")==0){
    						postResult=new Msg(102,SYSVALUE.MESSAGE.get("E_USER_EXIST")).toString();
    					}
    					throw new RuntimeException();
    				}
//    				else if(nimCode==200&&content.getJSONObject("info").getString("accid")==user.getPhone()){
//    					postResult=new Msg(200,SYSVALUE.MESSAGE.get("E_USER_EXIST")).toString();
//    				}
    			}else{
    				throw new RuntimeException();
    			}
    		}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}finally{
			if(dbResult==-1||postResult.equals("")){
				postResult=new Msg(103,SYSVALUE.MESSAGE.get("E_SYSTEM")).toString();
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		}
        return postResult;
    }
	public List<User> findUser(User user) {
		List<User> userList=userDAO.findUser(user);
		return userList;
	}
}