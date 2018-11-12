package com.agan.book.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="get",method=RequestMethod.GET)
	public Product getProduct(@RequestParam("id") Integer id){
		return this.productService.getProduct(id);
	}
	
	//---------------------------多参数------------------------------
	//不能这么写，因为feign会自动转换为post
	@RequestMapping(value="get1",method=RequestMethod.GET)
	public Product getProduct1( Product obj){
		return this.productService.getProduct1(obj);
	}

	@RequestMapping(value="get2",method=RequestMethod.GET)
	public Product getProduct2(@RequestParam("id") Integer id,@RequestParam("name") String name){
		return this.productService.getProduct2(id,name);
	}
	//---------------------------post------------------------------
	@RequestMapping(value="add",method=RequestMethod.GET)
	public Product addProduct(){
		Product obj=new Product(2,"漫谈spring cloud分布式服务架构（微服务进阶篇）");
		return this.productService.addProduct(obj);
	}
}
