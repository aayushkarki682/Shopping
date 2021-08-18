package com.shopping.demo.service;

import com.shopping.demo.model.Seller;
import com.shopping.demo.repository.SellerRepository;

import java.util.List;

public class SellerServiceImpl implements SellerService{

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }
}
