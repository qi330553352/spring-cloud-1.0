package com.example.qixin.feign;

import java.util.List;

import com.example.qixin.entity.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 创  建   时  间： 2018/11/10 16:28
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@RequestMapping("/product")
public interface ProductApi {

    @RequestMapping(value="list",method=RequestMethod.GET)
    public List<Product> listProduct();

    @RequestMapping(value="findAllProduct",method=RequestMethod.GET)
    public List<Product> findAllProduct();


    @RequestMapping(value="get",method=RequestMethod.GET)
    public Product getProduct(@RequestParam("id") Integer id);

    //---------------------------多参数------------------------------
    @RequestMapping(value="get1",method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct1(Product obj);

    @RequestMapping(value="get2",method=RequestMethod.GET)
    public Product getProduct2(@RequestParam("id") Integer id,@RequestParam("name") String name);

    //---------------------------post------------------------------
    @RequestMapping(value="add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@RequestBody Product obj);
}
