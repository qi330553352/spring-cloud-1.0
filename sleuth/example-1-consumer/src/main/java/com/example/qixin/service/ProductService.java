package com.example.qixin.service;

import com.example.qixin.feign.ProductApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 创  建   时  间： 2018/11/10 16:13
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@FeignClient(name="example-1-consumer")
public interface ProductService extends ProductApi{

}
