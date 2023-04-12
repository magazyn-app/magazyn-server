package com.magazyn.magazynserver.controller;

import com.magazyn.magazynserver.data.model.Cart;
import com.magazyn.magazynserver.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.magazyn.magazynserver.config.Constants.api_ALL;
import static com.magazyn.magazynserver.config.Constants.api_CARTS;
import static com.magazyn.magazynserver.util.HttpUtil.toResponse;

import java.util.List;

@RestController
@RequestMapping(api_CARTS)
public class CartController {

    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(api_ALL)
    public ResponseEntity<List<Cart>> getAllCarts() {
        return toResponse(cartService.getAllCarts());
    }
}
