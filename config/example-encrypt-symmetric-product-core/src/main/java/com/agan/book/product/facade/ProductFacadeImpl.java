package com.agan.book.product.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agan.book.product.domain.Product;
import com.agan.book.product.service.ProductService;
/**
 * @author 阿甘
 * @see http://study.163.com/instructor/1016671292.htm
 * @version 1.0
 */
@RestController
public class ProductFacadeImpl implements ProductFacade{
	
	@Autowired
	private ProductService productService;
	
	public List<Product> findAllProduct(){
		return  this.productService.findAllProduct();
	}
	public List<Product> listProduct(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  this.productService.findAllProduct();
	}

	@Override
	public Product getProduct(Integer id) {
		return this.productService.getProduct(id);
	}

	@Override
	public Product getProduct1(@RequestBody Product obj) {
		return obj;
	}

	@Override
	public Product getProduct2(Integer id, String name) {
		return new Product(id,name);
	}

	@Override
	public Product addProduct(@RequestBody Product obj) {
		return obj;
	}




	
	
}
