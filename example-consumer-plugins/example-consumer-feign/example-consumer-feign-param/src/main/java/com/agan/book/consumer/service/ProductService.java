package com.agan.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.agan.book.product.facade.ProductFacade;
/**
 * @author 阿甘
 * @see http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@FeignClient(name="e-book-product")
public interface ProductService extends ProductFacade{
	
}
