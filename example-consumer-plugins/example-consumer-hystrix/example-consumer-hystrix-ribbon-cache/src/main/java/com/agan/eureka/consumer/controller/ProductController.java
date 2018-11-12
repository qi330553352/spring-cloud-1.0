package com.agan.eureka.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agan.eureka.consumer.domain.Product;
import com.agan.eureka.consumer.service.ProductService;

/**
 * @author 阿甘 http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<Product> listProduct() {
		List<Product> list = this.productService.listProduct();
		return list;
	}
	
	
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public Product get(Integer id){
		return this.productService.get(id);
	}
	@RequestMapping(value = "del", method = RequestMethod.GET)
	public void del(Integer id){
		this.productService.del(id);
	}
}
