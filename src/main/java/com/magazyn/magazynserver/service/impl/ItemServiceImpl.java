package com.magazyn.magazynserver.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.magazyn.magazynserver.exception.ItemTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.data.object.ItemType;
import com.magazyn.magazynserver.data.repository.ItemRepository;
import com.magazyn.magazynserver.service.ItemService;


@Component
public class ItemServiceImpl implements ItemService {

    private final ItemRepository items;

    @Autowired
    public ItemServiceImpl(ItemRepository itemsRepo) {
        this.items = itemsRepo;
    }

    @Override
    public List<Item> getAllItems() {
        return items.findAll();
    }

    @Override
    public List<Item> getTypedItems(String type) throws ItemTypeNotFoundException {
        List<Item> allItems = items.findAll();
        List<Item> typedItems = new ArrayList<>();

        allItems.forEach(item -> {
            try {
                var itemType = ItemType.valueOf(type.toUpperCase());
                if (item.getType().equals(itemType)) {
                    typedItems.add(item);
                }
            } catch (IllegalArgumentException e) {
                throw new ItemTypeNotFoundException("Item type not found: " + type);
            }
        });

        return typedItems;
    }

    @Override
    public List<Item> getItemById(Long id) {
        return items.findAllById(List.of(id));
    }

    @Override
    public List<Item> addItems(List<Item> itemsToAdd) {
        return items.saveAll(itemsToAdd);
    }

    public List<Item> getAllFoodFunctional(String type) {
        return items.findAll()
                .stream()
                .filter(item -> item.getType().equals(ItemType.valueOf(type)))
                .collect(Collectors.toList());
    }
}
