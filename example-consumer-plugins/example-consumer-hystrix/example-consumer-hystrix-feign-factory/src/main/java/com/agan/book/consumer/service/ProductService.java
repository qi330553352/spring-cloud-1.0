package com.agan.book.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agan.book.consumer.hystrix.ProductServiceFallbackFactory;
import com.agan.book.product.domain.Product;
import com.agan.book.product.facade.ProductFacade;
/**
 * @author 阿甘
 * @see http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@FeignClient(name="e-book-product",fallbackFactory=ProductServiceFallbackFactory.class)
public interface ProductService {
	
	@RequestMapping(value="product/list",method=RequestMethod.GET)
	public List<Product> listProduct();
}
