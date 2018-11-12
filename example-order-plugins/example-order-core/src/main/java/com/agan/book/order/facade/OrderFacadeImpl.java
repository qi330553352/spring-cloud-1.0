package com.agan.book.order.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agan.book.order.domain.Order;
import com.agan.book.order.service.OrderService;

@RestController
public class OrderFacadeImpl implements OrderFacade {

	@Autowired
	private OrderService orderService;

	@Override
	public List<Order> findOrderByUserId(Integer userId) {
		return this.orderService.findOrderByUserId(userId);
	}

	@Override
	public Integer createOrder(@RequestBody Order obj) {
		return this.orderService.createOrder(obj);
	}

	@Override
	public void updateOrderByTrade(@RequestBody Order obj) {
		this.orderService.updateOrderByTrade(obj);
	}

	@Override
	public Order findOrderById(Integer id) {
		return this.orderService.findOrderById(id);
	}

	

}
