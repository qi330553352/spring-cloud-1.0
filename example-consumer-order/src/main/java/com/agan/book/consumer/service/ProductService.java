package com.agan.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.agan.book.product.facade.ProductFacade;


@FeignClient(name="e-book-product")
public interface ProductService extends ProductFacade{

}
