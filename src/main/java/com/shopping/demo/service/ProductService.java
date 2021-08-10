package com.shopping.demo.service;

import com.shopping.demo.model.Products;

import java.util.List;

public interface ProductService {
    List<Products> getProducts();
    Products save(Products products);
}
