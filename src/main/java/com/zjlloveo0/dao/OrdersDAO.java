package com.zjlloveo0.dao;

import java.util.List;

import com.zjlloveo0.model.Orders;
import com.zjlloveo0.model.OrdersDetail;

public interface OrdersDAO {
	public int insertOrders(Orders orders);
	public int updateOrders(Orders orders);
	public List<Orders> findOrdersList(Orders orders);
	public List<OrdersDetail> findOrdersDetailList(Orders orders);
}
