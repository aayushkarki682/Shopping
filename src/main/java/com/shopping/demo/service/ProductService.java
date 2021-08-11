package com.shopping.demo.service;

import com.shopping.demo.model.Products;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Products> getProducts();
    Products save(String name, MultipartFile file, String description, double price);
}
