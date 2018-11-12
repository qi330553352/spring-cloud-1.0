package com.agan.book.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

	@Value("${book.config}")
	private String msg;
	
	@RequestMapping("/test")
	public String test(){
		return this.msg;
	}
}
