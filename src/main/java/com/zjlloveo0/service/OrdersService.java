package com.zjlloveo0.service;

import java.util.List;

import com.zjlloveo0.model.Orders;
import com.zjlloveo0.model.OrdersDetail;
import com.zjlloveo0.model.User;

public interface OrdersService {
	String updateOrders(Orders orders);
	String createOrders(Orders orders);
	List<Orders> findOrdersList(Orders orders);
	List<OrdersDetail> findOrdersDetailList(Orders orders);
}
