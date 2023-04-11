package com.magazyn.magazynserver.service.impl;

import com.magazyn.magazynserver.data.model.Cart;
import com.magazyn.magazynserver.data.repository.CartRepository;
import com.magazyn.magazynserver.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartServiceImpl implements CartService {

    private final CartRepository carts;

    @Autowired
    public CartServiceImpl(CartRepository carts) {
        this.carts = carts;
    }

    @Override
    public List<Cart> getAllCarts() {
        return carts.findAll();
    }
}
