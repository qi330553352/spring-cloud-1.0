package com.agan.eureka.consumer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.agan.eureka.consumer.domain.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
/**
 * @author 阿甘 http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@Service
public class ProductService {
	
	//利用hystrix合并请求  
    @HystrixCollapser(batchMethod = "batchProduct", scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,  
    		collapserProperties = {  
    		//请求时间间隔在50ms之内的请求会被合并为一个请求
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "20"),
            //设置触发批处理执行之前，在批处理中允许的最大请求数。
            @HystrixProperty(name = "maxRequestsInBatch", value = "200"),  
    })  
	public Future<Product> getProduct(Integer id){
		System.out.println("------------"+id+"-------------");
		return null;
	}
	
	@HystrixCommand
	public List<Product> batchProduct(List<Integer> ids){
		for(Integer id:ids){
			System.out.println(id);
		}
		
		List<Product> list=new ArrayList<Product>();
		list.add(new Product(1,"漫谈spring cloud与spring boot基础架构（微服务基础篇）"));
		list.add(new Product(2,"漫谈spring cloud分布式服务架构（微服务进阶篇）"));
		list.add(new Product(3,"漫谈spring cloud 与docker架构部署（微服务高级篇）"));
		list.add(new Product(4,"444444444444444444"));
		return  list;
	}
}
