package com.agan.book.trade.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.agan.book.order.facade.OrderFacade;


@FeignClient(name="e-book-order")
public interface OrderService extends OrderFacade{

}
