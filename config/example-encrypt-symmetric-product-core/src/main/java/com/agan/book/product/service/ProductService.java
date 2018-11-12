package com.agan.book.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agan.book.product.domain.Product;
import com.agan.book.product.persistence.ProductMapper;

/**
 * 
*@author 阿甘  
*@see  http://study.163.com/instructor/1016671292.htm
*@version 1.0 
*
 */
@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> findAllProduct(){
		return  this.productMapper.findAllProduct();
	}
	public List<Product> listProduct(){
		return  this.productMapper.findAllProduct();
	}

	public Product getProduct(Integer id) {
		return this.productMapper.selectByPrimaryKey(id);
	}
}
