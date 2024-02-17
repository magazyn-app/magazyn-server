package com.magazyn.magazynserver.controller;

import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.data.object.AddUserItemResponse;
import com.magazyn.magazynserver.service.CartManagerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.magazyn.magazynserver.config.Constants.*;
import static com.magazyn.magazynserver.util.HttpUtil.toResponse;

@Transactional
@RestController
@RequestMapping(api_CART)
public class CartController {

    private final CartManagerService cartManagerService;

    @Autowired
    public CartController(CartManagerService cartManagerService) {
        this.cartManagerService = cartManagerService;
    }

    @GetMapping(api_USER + api_PATH_VARIABLE)
    public ResponseEntity<List<UserItem>> getCartForUser(@PathVariable String pathVariable) {
        return toResponse(cartManagerService.userCart(pathVariable));
    }

    @DeleteMapping(api_USER + api_PATH_VARIABLE)
    public ResponseEntity<String> deleteCartForUser(@PathVariable String pathVariable) {
        return toResponse("", cartManagerService.deleteCart(pathVariable));
    }

    @DeleteMapping(api_USER + api_PATH_VARIABLE + api_ITEMS + "/{itemId}")
    public ResponseEntity<String> deleteItemEntry(@PathVariable String pathVariable, @PathVariable String itemId) {
        return toResponse("", cartManagerService.deleteItemEntry(pathVariable, itemId));
    }

    @DeleteMapping(api_USER + api_PATH_VARIABLE + api_ITEM + "/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable String pathVariable, @PathVariable String itemId) {
        return toResponse("", cartManagerService.deleteItem(pathVariable, itemId));
    }

    @PostMapping(api_USER + api_PATH_VARIABLE + api_ITEMS + "/{itemId}")
    public ResponseEntity<AddUserItemResponse> addNewItem(@PathVariable String pathVariable, @PathVariable String itemId) {
        return ResponseEntity.ok(cartManagerService.addNewItem(pathVariable, itemId));
    }
}
