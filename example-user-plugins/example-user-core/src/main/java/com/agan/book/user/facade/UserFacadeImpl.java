package com.agan.book.user.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.agan.book.user.service.UserService;
/**
 * @author 阿甘
 * @see http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RestController
public class UserFacadeImpl implements UserFacade{

	@Autowired
	private UserService userService;
	
	@Override
	public Integer login(String userName, String passWord) {
		return this.userService.login(userName, passWord);
	}
	
	
}
