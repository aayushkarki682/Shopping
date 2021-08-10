package com.shopping.demo.controller;

import com.shopping.demo.model.Cart;
import com.shopping.demo.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartRestController {

    private final CartService cartService;

    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/getCartInfo")
    public List<Cart> getAll(){
        return cartService.getAll();
    }

    @PostMapping("/saveCart/{productId}/{quantity}")
    public Cart saveCart(@PathVariable("productId") int productId, @PathVariable("quantity") int quantity){
        Cart cart = Cart.builder().productId(productId).quantity(quantity).build();
        return cartService.save(cart);
    }
}
