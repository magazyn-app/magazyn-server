package com.magazyn.magazynserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.service.ItemService;
import com.magazyn.magazynserver.service.impl.ItemServiceImpl;


@RestController
@RequestMapping("/item")
public class ItemController {
    
    private final ItemService itemService;

    @Autowired
    public ItemController (ItemServiceImpl itemServiceImpl){
        this.itemService = itemServiceImpl;
    }

    @GetMapping("/get-all")
    public List<Item> getAll() {
        return itemService.getAllItems();
    }

    @GetMapping("/get-all-food")
    public List<Item> getAllFood() {
        return itemService.getAllFood();
    }
}
