package com.agan.book.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agan.book.order.domain.Order;
import com.agan.book.order.persistence.OrderMapper;

@Service
public class OrderService  {

	@Autowired
	private OrderMapper orderMapper;

	public List<Order> findOrderByUserId(Integer userId) {
		return this.orderMapper.findOrderByUserId(userId);
	}

	public Integer createOrder(Order obj) {
		 this.orderMapper.insert(obj);
		 return obj.getId();
	}

	public void updateOrderByTrade(Order obj) {
		this.orderMapper.updateByPrimaryKey(obj);
	}
	
	public Order findOrderById(Integer id){
		return this.orderMapper.selectByPrimaryKey(id);
	}

}
