package com.agan.book.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.agan.book.consumer.service.ProductService;
import com.agan.book.product.domain.Product;

@Component
public class ProductServiceFallback implements ProductService{

	@Override
	public List<Product> listProduct() {
		List<Product>  list=new ArrayList<Product>();
		list.add(new Product(-1,"fallback"));
		return list;
	}

}
