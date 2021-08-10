package com.shopping.demo.bootstrap;

import com.shopping.demo.model.Cart;
import com.shopping.demo.model.Products;
import com.shopping.demo.service.CartService;
import com.shopping.demo.service.ProductService;
import com.shopping.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BootStrap implements CommandLineRunner {
    private final ProductService productService;
    private final CartService cartService;

    public BootStrap(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Products product1 = Products.builder().description("laptop").pathToImage("path/to/image").price(12.2).build();

        Products product2 = Products.builder().description("football").pathToImage("path/to/image").price(12.2).build();
        Products product3 = Products.builder().description("pen").pathToImage("path/to/image").price(12.2).build();
        Products product4 = Products.builder().description("jpt").pathToImage("path/to/image").price(12.2).build();
        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);

        Cart cart1 = Cart.builder().productId(product1.getId()).quantity(2).build();
        Cart cart2 = Cart.builder().productId(product2.getId()).quantity(3).build();
        cartService.save(cart1);
        cartService.save(cart2);
        System.out.println("Database initialized with mock datas");
    }
}
