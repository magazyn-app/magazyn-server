package com.magazyn.magazynserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.magazyn.magazynserver.data.model.Item;

@Service
public interface ItemService {
    List<Item> getAllFood();

    List<Item> getAllItems();

    List<Item> getItemById(Long id);

    List<Item> addItems(List<Item> items);
}
