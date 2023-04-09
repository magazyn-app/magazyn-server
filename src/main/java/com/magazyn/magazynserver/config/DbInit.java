package com.magazyn.magazynserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.data.object.ItemType;
import com.magazyn.magazynserver.data.repository.ItemRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DbInit {

    private final ItemRepository items;

    @Autowired
    public DbInit(ItemRepository items) {
        this.items = items;
    }

    @PostConstruct
    public void init () {
        Item item1 = new Item( null, "water", 69.69, ItemType.FOOD);

        items.save(item1);
    }
}

