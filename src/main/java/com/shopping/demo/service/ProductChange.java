package com.shopping.demo.service;

import com.shopping.demo.model.Products;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProductChange implements ProductService{
    @Override
    public List<Products> getProducts() {
        return null;
    }

    @Override
    public Products save(String name, MultipartFile file, String description, double price) {
        return null;
    }

    public Products delete(int id){
        return new Products();
    }

}
