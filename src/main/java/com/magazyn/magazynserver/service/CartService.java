package com.magazyn.magazynserver.service;

import com.magazyn.magazynserver.data.model.Cart;
import com.magazyn.magazynserver.data.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    List<Cart> getAllCarts();
}
