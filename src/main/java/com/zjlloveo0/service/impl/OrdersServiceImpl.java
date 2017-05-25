package com.zjlloveo0.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.zjlloveo0.dao.OrdersDAO;
import com.zjlloveo0.dao.UserDAO;
import com.zjlloveo0.model.Msg;
import com.zjlloveo0.model.Orders;
import com.zjlloveo0.model.OrdersDetail;
import com.zjlloveo0.model.User;
import com.zjlloveo0.service.OrdersService;
import com.zjlloveo0.util.MiPush;
import com.zjlloveo0.util.SYSVALUE;
@Service
@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false,isolation=Isolation.DEFAULT)
public class OrdersServiceImpl implements OrdersService {
	@Autowired
    @Qualifier("ordersDAO")
	private OrdersDAO ordersDAO;
	@Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO;
	public String updateOrders(Orders orders) {
		int updateU1=-1;
		int updateU2=-1;
		int updateM=-1;
		Orders i=new Orders();
		i.setId(orders.getId());
		List<Orders> oList=findOrdersList(i);
		if(oList.size()<1||oList.get(0).getIsEnable()==0){
			return new Msg(115,SYSVALUE.MESSAGE.get("E_ORDERS_NO_EXIST")).toString();
		}
		Orders o=oList.get(0);
		Integer changeState=orders.getState();
		if(changeState!=null){
			switch (o.getState()){
		        case 0:
		        	//s="服务已申请";
		        	if(!(changeState==1||changeState==4||changeState==8)){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
		        break;
		        case 1:
		        	//s="订单已接受";
		        	if(!(changeState==2||changeState==5||changeState==6)){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
		        break;
		        case 2:
		        	//s="订单已完成";
		        	if(changeState!=3){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
		        break;
		        case 3:
		        	//s="订单已结束";
		        	return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        case 4:
		        	//s="订单被拒绝";
		        	return new Msg(403,"T_STATE_TO_REFRESH").toString();
		        case 5:
		        	//s="服务使用者终止订单";
		        	if(changeState!=7){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
		        break;
		        case 6:
		        	//s="服务提供者终止订单";
		        	if(changeState!=7){
		        		return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
		        	}
		        break;
		        default:return new Msg(403,SYSVALUE.MESSAGE.get("T_STATE_TO_REFRESH")).toString();
			}
			if(changeState==3){
				User u1=new User();
				u1.setId(o.getCreateId());
				List<User> uL1=userDAO.findUser(u1);
				User u2=new User();
				u2.setId(o.getUId());
				List<User> uL2=userDAO.findUser(u2);
				if(uL1.size()==1&&uL2.size()==1){
					u1=uL1.get(0);
					u2=uL2.get(0);
					User uu1=new User();
					User uu2=new User();
					uu1.setId(u1.getId());
					uu1.setPoint((u1.getPoint()==null?0:u1.getPoint())-(o.getExchangePoint()==null?0:o.getExchangePoint()));
					uu2.setId(u2.getId());
					uu2.setPoint((u2.getPoint()==null?0:u2.getPoint())+(o.getExchangePoint()==null?0:o.getExchangePoint()));
					try {
						if(uu1.getPoint()<=SYSVALUE.POINT_MIN){
							MiPush.sendMessageToAlias("积分余额不足", "您的积分余额已不足"+SYSVALUE.POINT_MIN+"分，为避免系统停用您的账户，请尽快通过充值或帮别人完成任务来获取积分", u1.getName()+",您的积分余额已不足，请尽快获取积分", u1.getId()+"",0,"","");
						}
						if(uu2.getPoint()<=SYSVALUE.POINT_MIN){
							MiPush.sendMessageToAlias("积分余额不足", "您的积分余额已不足"+SYSVALUE.POINT_MIN+"分，为避免系统停用您的账户，请尽快通过充值或帮别人完成任务来获取积分", u2.getName()+",您的积分余额已不足，请尽快获取积分", u2.getId()+"",0,"","");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					updateU1=userDAO.updateUser(uu1);
					updateU2=userDAO.updateUser(uu2);
					if(!(updateU1==1&&updateU2==1)){
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return new Msg(401,SYSVALUE.MESSAGE.get("T_FAIL")).toString();
					}
				}else{
					return new Msg(401,SYSVALUE.MESSAGE.get("T_FAIL")).toString();
				}
			}
			
			
		}
		updateM=ordersDAO.updateOrders(orders);
		if(updateM==1){
			try {
				MiPush.sendMessageToAlias("REFRESH", o.getId()+"", "SERVER_ORDERS_DETAIL", o.getUId()+","+o.getCreateId(),1,"","");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new Msg(400,SYSVALUE.MESSAGE.get("T_SUCCESS")).toString();
		}else{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return new Msg(401,SYSVALUE.MESSAGE.get("T_FAIL")).toString();
		}
	}

	public String createOrders(Orders orders) {
		Orders o=new Orders();
		o.setCreateId(orders.getCreateId());
		o.setServerId(orders.getServerId());
		o.setUId(orders.getUId());
		o.setState(0);
		o.setIsEnable(1);
		if(findOrdersList(o).size()>0){
			return new Msg(114,SYSVALUE.MESSAGE.get("E_ORDERS_EXIST")).toString();
		}else if(ordersDAO.insertOrders(orders)==1){
			try {
				String s=MiPush.sendMessageToAlias("你有新的服务订单！", orders.getId()+"", "有人使用了你的服务，快来帮TA吧！", orders.getUId()+"",0,"TARGET","SERVER_ORDERS_DETAIL");
				if("".equals(s)){
					return new Msg(204,SYSVALUE.MESSAGE.get("S_CREATE_ORDERS")).toString();
				}else{
					throw new RuntimeException(s);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new Msg(205,SYSVALUE.MESSAGE.get("S_CREATE_ORDERS_NO_NOTICE")).toString();
			}
		}else{
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return new Msg(401,SYSVALUE.MESSAGE.get("T_FAIL")).toString();
		}
	}

	public List<Orders> findOrdersList(Orders orders) {
		return ordersDAO.findOrdersList(orders);
	}
	public List<OrdersDetail> findOrdersDetailList(Orders orders) {
		return ordersDAO.findOrdersDetailList(orders);
	}

}
