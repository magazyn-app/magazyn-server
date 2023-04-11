package com.magazyn.magazynserver.controller;

import com.magazyn.magazynserver.data.model.Cart;
import com.magazyn.magazynserver.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.magazyn.magazynserver.util.HttpUtil.toResponse;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cart>> getAllCarts() {
        return toResponse(cartService.getAllCarts());
    }
}
