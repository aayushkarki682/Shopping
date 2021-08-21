package com.shopping.demo.controller;

import com.shopping.demo.model.Cart;
import com.shopping.demo.service.CartService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @PostMapping("/saveCart")
    public Cart saveCart(@RequestBody Cart cart){
        System.out.println(cart.getProductId());
        return cartService.save(cart);
    }

    @PutMapping("/updateCart")
    public void updateCart(@RequestBody Cart cart){
        System.out.println(cart.getQuantity());
         cartService.update(cart);
    }
}
