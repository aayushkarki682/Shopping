package com.shopping.demo.controller;

import com.shopping.demo.model.Products;
import com.shopping.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getProducts")
    public List<Products> getAllProducts(){

        List<Products> products = new ArrayList<>();
        products = productService.getProducts();

        return products;
    }

    @GetMapping("/")
    public String getIt(){
        return "Aayush";
    }
}
