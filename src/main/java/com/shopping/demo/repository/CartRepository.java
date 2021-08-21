package com.shopping.demo.repository;

import com.shopping.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Modifying
    @Query("update Cart c set c.quantity = ?2 where c.id = ?1")
    void updateCartInfo(int cartId, int quantity);
}
