package com.shopping.demo.service;

import com.shopping.demo.model.Seller;

import java.util.List;

public interface SellerService {
    Seller save(Seller seller);
    List<Seller> getAll();
}
