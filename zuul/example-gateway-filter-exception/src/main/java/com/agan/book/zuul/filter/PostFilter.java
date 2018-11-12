package com.agan.book.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * 
*@author 阿甘  
*@see  http://study.163.com/instructor/1016671292.htm
*@version 1.0 
 */
@Component
public class PostFilter extends ZuulFilter{

	private static final Logger logger =LoggerFactory.getLogger(PostFilter.class);
	
	/**
	 * 开启过滤器
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的作用，post验证
	 */
	@Override
	public Object run() {
		RequestContext rc=RequestContext.getCurrentContext();
		HttpServletRequest request=rc.getRequest();
		logger.info("--------------post-------------------");
		
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
