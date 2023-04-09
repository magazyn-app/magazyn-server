package com.magazyn.magazynserver.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.magazyn.magazynserver.data.model.Item;

@Component
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByItemId(Long itemId);
}
