package com.magazyn.magazynserver.service;

import java.util.List;

import com.magazyn.magazynserver.exception.ItemTypeNotFoundException;
import org.springframework.stereotype.Service;

import com.magazyn.magazynserver.data.model.Item;

@Service
public interface ItemService {
    List<Item> getTypedFoods(String type) throws ItemTypeNotFoundException;

    List<Item> getAllItems();

    List<Item> getItemById(Long id);

    List<Item> addItems(List<Item> items);
}
