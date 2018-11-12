package com.example.qixin.service;

import com.example.qixin.feign.ProductApi;
import org.springframework.cloud.netflix.feign.FeignClient;


@FeignClient(name="zipkin-product-server")
public interface ProductService extends ProductApi{

}
