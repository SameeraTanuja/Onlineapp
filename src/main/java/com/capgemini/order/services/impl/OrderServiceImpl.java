package com.capgemini.order.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.order.entity.Order;
import com.capgemini.order.exception.OrderNotFoundException;
import com.capgemini.order.repository.OrderRepository;
import com.capgemini.order.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order getOrder(int orderId) {
		
		
			Optional<Order> optionalOrder = orderRepository.findById(orderId);
			if(optionalOrder.isPresent()) {
				Order order = optionalOrder.get();
				orderRepository.save(order);
				return order;
		

		}
			return null;
		}
		
	

	@Override
	public Order submitOrder(Order order) {
		//order.setOrderDate(LocalDate.now());
		return orderRepository.save(order);
		
		
	}

	@Override
	public Order updateOrder(Order order) {
		order.setStatus("UPDATED");
		orderRepository.save(order);
		return order;
	}

	@Override
	public Order deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		Optional<Order> optionalOrder=orderRepository.findById(orderId);
		if(optionalOrder.isPresent())
		{
			Order order=optionalOrder.get();
			order.setStatus("DELETED");
			orderRepository.save(order);
			return order;
			
		}
		return null;
	
		
	}

	@Override
	public Order cancelOrder(int orderId) {
		// TODO Auto-generated method stub
		Optional<Order> optionalOrder=orderRepository.findById(orderId);
		if(optionalOrder.isPresent())
		{
			Order order=optionalOrder.get();
			order.setStatus("CANCELLED");
			orderRepository.save(order);
			return order;
		}
		return null;
		
	}

	@Override
	public List<Order> getOrders() {
	
		return orderRepository.findAll();
	}



	@Override
	public List<Order> getOrdersByCustomerId(int orderCustomerId) {
		// TODO Auto-generated method stub
		return orderRepository.findByOrderCustomerId(orderCustomerId);
		
		}
	
	
	}


