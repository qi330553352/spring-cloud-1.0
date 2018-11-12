package com.agan.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.agan.book.trade.facade.TradeFacade;


@FeignClient(name="e-book-trade")
public interface TradeService extends TradeFacade{

}
