package com.shopping.demo.service;

import com.shopping.demo.model.Products;
import com.shopping.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> getProducts() {
        List<Products> products = productRepository.findAll();
        return products;
    }

    @Override
    public Products save(Products products) {
        return productRepository.save(products);
    }
}
