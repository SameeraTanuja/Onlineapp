package com.capgemini.order.services;

import java.util.List;

import com.capgemini.order.entity.Order;


public interface OrderService {
	public Order getOrder(int orderId);
	public Order submitOrder(Order order);
	public Order updateOrder(Order order);
	public Order deleteOrder(int orderId);
	public Order cancelOrder(int orderId);
	public List<Order> getOrders();
	public List<Order> getOrdersByCustomerId(int orderCustomerId);
	

}
