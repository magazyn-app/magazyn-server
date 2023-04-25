package com.magazyn.magazynserver.controller;

import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.service.CartManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.magazyn.magazynserver.config.Constants.api_CART;
import static com.magazyn.magazynserver.config.Constants.api_PATH_VARIABLE;
import static com.magazyn.magazynserver.config.Constants.api_USER;


@RestController
@RequestMapping(api_CART)
public class CartController {

    CartManagerService cartManagerService;

    @Autowired
    public CartController(CartManagerService cartManagerService) {
        this.cartManagerService = cartManagerService;
    }

    @GetMapping(api_USER + api_PATH_VARIABLE)
    public List<UserItem> getCartForUser(@PathVariable String pathVariable) {
        return cartManagerService.userCart(pathVariable);
    }
}
