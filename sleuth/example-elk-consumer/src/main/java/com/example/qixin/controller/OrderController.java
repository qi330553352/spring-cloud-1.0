package com.example.qixin.controller;

import com.example.qixin.entity.Product;
import com.example.qixin.service.ProductService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * 创  建   时  间： 2018/11/10 16:56
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RestController
public class OrderController {

    @Autowired
    private ProductService productService;
    private Logger log = Logger.getLogger(OrderController.class);

    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public Object productList()  {
        RestTemplate template = new RestTemplate();
        Object obj = template.getForEntity("http://localhost:8083/product/findAllProduct",Object.class).getBody();
        log.info("obj:"+obj);

//        List<Product> products = this.productService.findAllProduct();
//        log.info("obj:"+products);
        return obj;
    }

}
