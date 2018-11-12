package com.agan.eureka.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.agan.eureka.consumer.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
/**
 * @author 阿甘 http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@Service
public class ProductService {
	@Autowired
	private LoadBalancerClient loadBalancerClient;//ribbon 负载均衡客户端
	
	@HystrixCommand(groupKey="e-book-product", commandKey = "listProduct",
		    threadPoolKey="e-book-product", 
		    		threadPoolProperties = {
		            @HystrixProperty(name = "coreSize", value = "30"),//线程池大小
		            @HystrixProperty(name = "maxQueueSize", value = "100"),//最大队列长度
		            @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),//线程存活时间
		            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15")//拒绝请求
		    },
		    fallbackMethod = "fallback")
	public List<Product> listProduct(){
		ServiceInstance si=loadBalancerClient.choose("e-book-product");
		StringBuffer sb=new StringBuffer("");
		sb.append("http://");
		sb.append(si.getHost());
		sb.append(":");
		sb.append(si.getPort());
		sb.append("/product/list");
		System.out.println(sb.toString());
		
		RestTemplate rt=new RestTemplate();
		ParameterizedTypeReference<List<Product>> typeRef
					=new ParameterizedTypeReference<List<Product>>(){};
		ResponseEntity<List<Product>>	resp=rt.exchange(sb.toString(), HttpMethod.GET, null, typeRef)	;	
		List<Product> plist=resp.getBody();
		return plist;
	}
	
	public List<Product> fallback(){
		List<Product> list=new ArrayList<Product>();
		list.add(new Product(-1,"fallback"));
		return list;
	}
}
