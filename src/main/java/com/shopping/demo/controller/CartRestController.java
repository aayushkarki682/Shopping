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

    @PostMapping(value = "/saveCart", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Cart saveCart(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity){
        Cart cart = Cart.builder().productId(productId).quantity(quantity).build();
        return cartService.save(cart);
    }
}
