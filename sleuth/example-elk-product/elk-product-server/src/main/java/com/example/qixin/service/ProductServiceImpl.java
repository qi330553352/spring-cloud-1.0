package com.example.qixin.service;

import com.example.qixin.entity.Product;
import com.example.qixin.feign.ProductApi;
import com.example.qixin.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 创  建   时  间： 2018/11/10 16:33
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RestController
public class ProductServiceImpl implements ProductApi {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> findAllProduct(){
        return  this.productMapper.findAllProduct();
    }
    public List<Product> listProduct(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  this.productMapper.findAllProduct();
    }

    @Override
    public Product getProduct(Integer id) {
        return this.productMapper.selectByPrimaryKey(id);
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
