package com.shopping.demo.service;

import com.shopping.demo.model.Products;
import com.shopping.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public Products save(String name, MultipartFile file, String description, double price) {
        Products products = Products.builder().name(name).description(description).price(price).build();
        try{
            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i = 0;
            for(byte b: file.getBytes()){
                byteObjects[i++] =b;
            }
            products.setImage(byteObjects);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }


        return productRepository.save(products);
    }
}
