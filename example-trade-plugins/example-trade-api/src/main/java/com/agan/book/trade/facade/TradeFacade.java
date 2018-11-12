package com.agan.book.trade.facade; 

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agan.book.trade.domain.Trade;

@RequestMapping("/trade")
public interface TradeFacade {
	
	@RequestMapping(value = "/createTrade", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createTrade(Trade obj);    
}
 