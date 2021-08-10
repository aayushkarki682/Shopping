package com.shopping.demo.service;

import com.shopping.demo.model.Cart;

import java.util.List;

public interface CartService {

    Cart save(Cart cart);
    List<Cart> getAll();
}
