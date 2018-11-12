package com.agan.book.trade.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agan.book.order.domain.Order;
import com.agan.book.trade.domain.Trade;
import com.agan.book.trade.service.OrderService;
import com.agan.book.trade.service.TradeService;

@RestController
public class TradeFacadeImpl implements TradeFacade {

	@Autowired
	private TradeService tradeService;
	
	@Autowired
	private OrderService orderService;

	@Override
	public void createTrade(@RequestBody Trade obj) {
		this.tradeService.createTrade(obj);
		
		
		//回填 订单里面的交易号
		Order order=this.orderService.findOrderById(obj.getOrderId());
//		Order order=new Order();
//		order.setId(obj.getId());
		order.setTradeId(obj.getId());
		order.setTradeStatus(true);
		this.orderService.updateOrderByTrade(order);
	}

	
}
