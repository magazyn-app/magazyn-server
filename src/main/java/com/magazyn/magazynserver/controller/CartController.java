package com.magazyn.magazynserver.controller;

import com.magazyn.magazynserver.data.object.UserItemDetails;
import com.magazyn.magazynserver.service.CartManagerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.magazyn.magazynserver.config.Constants.api_CART;


@RestController
@RequestMapping(api_CART)
public class CartController {

    CartManagerService cartManagerService;

    @Autowired
    public CartController(CartManagerService cartManagerService) {
        this.cartManagerService = cartManagerService;
    }

    @GetMapping("/test")
    public List<UserItemDetails> getCartForUser() {
        return cartManagerService.userCart();
    }
}
