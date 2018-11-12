package com.agan.book.user.facade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author 阿甘
 * @see http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RequestMapping("/user")
public interface UserFacade {
	
	
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public Integer login(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord);
	
}
