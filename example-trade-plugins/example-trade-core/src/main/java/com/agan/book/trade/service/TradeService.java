package com.agan.book.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agan.book.trade.domain.Trade;
import com.agan.book.trade.persistence.TradeMapper;

@Service
public class TradeService  {

	@Autowired
	private TradeMapper tradeMapper;

	public void createTrade(Trade obj){
		this.tradeMapper.insert(obj);
	}
	

}
