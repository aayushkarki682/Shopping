package com.shopping.demo.service;

import com.shopping.demo.model.Cart;
import com.shopping.demo.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Cart cart) {

         cartRepository.updateCartInfo(cart.getId(), cart.getQuantity());
    }
}
