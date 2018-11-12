package com.agan.book.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agan.book.user.persistence.UserMapper;

/**
 * 
*@author 阿甘  
*@see  http://study.163.com/instructor/1016671292.htm
*@version 1.0 
*
 */
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMaper;
	
	public Integer login(String userName, String passWord){
		return this.userMaper.login(userName, passWord);
	}
}
