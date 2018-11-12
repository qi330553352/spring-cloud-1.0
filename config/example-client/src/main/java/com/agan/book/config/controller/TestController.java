package com.agan.book.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 阿甘 http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RestController
public class TestController {

	@Value("${book.config}")
	private String msg;
	
	@RequestMapping("/test")
	public String test(){
		return this.msg;
	}
}
