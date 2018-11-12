package com.agan.book.consumer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agan.book.consumer.service.OrderService;
import com.agan.book.consumer.service.ProductService;
import com.agan.book.consumer.service.TradeService;
import com.agan.book.consumer.service.UserService;
import com.agan.book.order.domain.Order;
import com.agan.book.product.domain.Product;
import com.agan.book.trade.domain.Trade;

@RestController
public class OrderController {
	

	
	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private TradeService tradeService;

	/**
	 * 模拟内容： 登录 查看产品 下订单 
	 * 
	 * 1.测试登录 账号 admin admin 
	 * 2.查看所有产品列表 
	 * 3.选第一款产品，下订单 
	 * 4.实现订单交易支付
	 * 5.查看所有的订单信息
	 * 
	 * @throws ParseException
	 */
	@RequestMapping(value = "/createOrder", method = RequestMethod.GET)
	public List<Order> createOrder()  {

		// 1.测试登录 账号 admin admin
		Integer userid = this.login();
		// 2.查看所有产品列表
		List<Product> products = this.productService.findAllProduct();
		// 3.选第一款产品，下订单
		Product product = products.get(0);
		Order order = new Order();
		order.setUserId(userid);
		order.setProductId(product.getId());
		order.setPrice(product.getPrice());
		Integer orderid=this.orderService.createOrder(order);
//		System.out.println(order.getId()+"------------------------------------------------");
//		return null;
//		 4.实现订单交易支付
		Trade trade = new Trade();
		trade.setUserId(order.getUserId());
		trade.setOrderId(orderid);
		trade.setPrice(order.getPrice());
		trade.setPayType((byte)1);// 支付类型:1-支付宝支付，2-网银在线，3-银联，4-微信支付
		trade.setPayStatus((byte)4);// 1 未付款 2 付款中 3 付款失败 4 付款完成
		trade.setGatewayPayNum(String.valueOf((new Date()).getTime()));// 网关支付流水号取当前时间
		trade.setGatewayPayPrice(order.getPrice());
		trade.setGatewayPayTime(new Date());
		this.tradeService.createTrade(trade);
		// 5.查看所有的订单信息
		List<Order> orders = this.orderService.findOrderByUserId(userid);
		return orders;
	}

	private Integer login() {
		String userName = "admin";
		String password = "admin";
		Integer id = this.userService.login(userName, password);
		if (id != null) {
			System.out.println("登录成功 id=" + id);
		} else {
			System.out.println("登录失败");
		}
		return id;
	}
}
