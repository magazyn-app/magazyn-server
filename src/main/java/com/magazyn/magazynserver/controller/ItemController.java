package com.magazyn.magazynserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.service.ItemService;
import com.magazyn.magazynserver.service.impl.ItemServiceImpl;

import static com.magazyn.magazynserver.config.Constants.*;
import static com.magazyn.magazynserver.util.HttpUtil.toResponse;


@RestController
@RequestMapping(api_ITEMS)
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemServiceImpl) {
        this.itemService = itemServiceImpl;
    }

    @GetMapping(api_ALL)
    public ResponseEntity<List<Item>> getAll() {
        return toResponse(itemService.getAllItems());
    }

    @GetMapping(api_ALL + api_PATH_VARIABLE)
    public ResponseEntity<List<Item>> getTypedItems(@PathVariable String pathVariable) {
        return toResponse(itemService.getTypedFoods(pathVariable));
    }

    @GetMapping(api_PATH_VARIABLE)
    public ResponseEntity<List<Item>> getItemById(@PathVariable String pathVariable) {
        return toResponse(itemService.getItemById(Long.valueOf(pathVariable)));
    }

    @PostMapping
    public ResponseEntity<List<Item>> addItems(@RequestBody List<Item> items) {
        return toResponse(itemService.addItems(items));
    }
}
