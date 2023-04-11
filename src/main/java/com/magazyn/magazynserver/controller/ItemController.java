package com.magazyn.magazynserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.service.ItemService;
import com.magazyn.magazynserver.service.impl.ItemServiceImpl;

import static com.magazyn.magazynserver.util.HttpUtil.toResponse;


@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemServiceImpl) {
        this.itemService = itemServiceImpl;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Item>> getAll() {
        return toResponse(itemService.getAllItems());
    }

    @GetMapping("/get-all-food")
    public ResponseEntity<List<Item>> getAllFood() {
        return toResponse(itemService.getAllFood());
    }

    @PostMapping
    public ResponseEntity<List<Item>> addItems(@RequestBody List<Item> items) {
        return toResponse(itemService.addItems(items));
    }
}
