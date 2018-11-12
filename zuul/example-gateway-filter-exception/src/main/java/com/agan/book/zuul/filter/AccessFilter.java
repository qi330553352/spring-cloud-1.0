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
public class AccessFilter extends ZuulFilter{

	private static final Logger logger =LoggerFactory.getLogger(AccessFilter.class);
	
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
		logger.info("--------------pre1-------------------");
		String token=request.getParameter("token");
		if(token==null){
			logger.warn("token is null............");
			rc.setSendZuulResponse(false);//代表结束请求，不在继续下级传递。
			rc.setResponseStatusCode(401);
			rc.setResponseBody("{\"result\":\"token is null\"}");
			rc.getResponse().setContentType("text/html;charset=utf-8");
		}else{
//			TODO  redis 验证
			logger.info("token is OK");
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
