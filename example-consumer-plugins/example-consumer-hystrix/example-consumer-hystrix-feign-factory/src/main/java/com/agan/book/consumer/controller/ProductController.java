package com.agan.book.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agan.book.consumer.service.ProductService;
import com.agan.book.product.domain.Product;
/**
 * @author 阿甘
 * @see http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product> listProduct(){
		List<Product> list=this.productService.listProduct();
		return  list;
	}
}
