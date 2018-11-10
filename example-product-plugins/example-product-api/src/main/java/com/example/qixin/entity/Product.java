package com.example.qixin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 创  建   时  间： 2018/11/10 16:25
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Byte status;

    private Integer price;

    private Byte deleted;

    private Date createTime;

    private Date updateTime;

    private String detail;

    public Product() {
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
