package com.magazyn.magazynserver.service.impl;

import java.util.ArrayList;
import java.util.List;

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
    public ItemServiceImpl (ItemRepository itemsRepo){
        this.items = itemsRepo;
    }

    @Override
    public List<Item> getAllItems (){
        return items.findAll();
    }

    @Override
    public List<Item> getAllFood (){
        List<Item> allItems = items.findAll();
        List<Item> allFoodItems = new ArrayList<>();
        allItems.forEach(item -> {
            if (item.getType().equals(ItemType.FOOD)){
                allFoodItems.add(item);
            }
        });        
        return allFoodItems;
    }
}
