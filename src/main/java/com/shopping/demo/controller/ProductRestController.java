package com.shopping.demo.controller;

import com.shopping.demo.model.Products;
import com.shopping.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping(value="/uploadProducts", produces = {MediaType.IMAGE_JPEG_VALUE, "application/json"})
    public ResponseEntity<?> saveProductInfo(@RequestParam("name") String name, @RequestParam("imageFile")MultipartFile file,
                                          @RequestParam("description") String description, @RequestParam("price") double price){
        Products products = productService.save(name, file, description, price);
        if(products == null){
            return new ResponseEntity<>("Unable to upload the product info", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(name, HttpStatus.CREATED);

    }
}
