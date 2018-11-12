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
* 这个类的目的 就是为了验证 filterOrder的顺序
 */
@Component
public class TestPreFilter extends ZuulFilter{

	private static final Logger logger =LoggerFactory.getLogger(TestPreFilter.class);
	
	/**
	 * 开启过滤器
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的作用，权限校验
	 */
	@Override
	public Object run() {
		RequestContext rc=RequestContext.getCurrentContext();
		HttpServletRequest request=rc.getRequest();
		logger.info("--------------pre2-------------------");
//		throw new RuntimeException("error");
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
