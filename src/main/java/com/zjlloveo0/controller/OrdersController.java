package com.zjlloveo0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjlloveo0.model.Msg;
import com.zjlloveo0.model.Orders;
import com.zjlloveo0.model.OrdersDetail;
import com.zjlloveo0.model.User;
import com.zjlloveo0.model.UserSchool;
import com.zjlloveo0.service.OrdersService;
import com.zjlloveo0.service.UserSchoolService;
import com.zjlloveo0.service.UserService;
import com.zjlloveo0.util.SYSVALUE;
 
@Controller
public class OrdersController {
 
	@Autowired
	private OrdersService ordersService;
	
	@ResponseBody
    @RequestMapping(value="findOrders",produces = "text/plain;charset=utf-8")
    public String findOrders(Orders orders){
    	List<Orders> ordersList=ordersService.findOrdersList(orders);
    	return new Msg(ordersList.size(),ordersList.toString()).toString();
    }
	
	@ResponseBody
    @RequestMapping(value="findOrdersDetail",produces = "text/plain;charset=utf-8")
    public String findOrdersDetail(Orders orders){
    	List<OrdersDetail> ordersList=ordersService.findOrdersDetailList(orders);
    	return new Msg(ordersList.size(),ordersList.toString()).toString();
    }
	
    @ResponseBody
    @RequestMapping(value="createOrders",produces = "text/plain;charset=utf-8")
    public String createOrders(Orders orders){
    	if(orders==null||orders.getCreateId()==null||"".equals(orders.getCreateId())
    			||orders.getUId()==null||"".equals(orders.getUId())
    			||orders.getServerId()==null||"".equals(orders.getServerId())
    			||orders.getExchangePoint()==null||"".equals(orders.getExchangePoint())){
    		return new Msg(113, SYSVALUE.MESSAGE.get("E_ORDERS_LESS_FIELD"))
			.toString();
    	}
        return ordersService.createOrders(orders);
    }
    @ResponseBody
    @RequestMapping(value="updateOrders",produces = "text/plain;charset=utf-8")
    public String updateOrders(Orders orders){
    	if(orders==null||orders.getId()==null||orders.getId()==0){
    		return new Msg(113, SYSVALUE.MESSAGE.get("E_ORDERS_LESS_FIELD"))
			.toString();
    	}
    	return ordersService.updateOrders(orders);
    }
}
