package com.magazyn.magazynserver;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.data.repository.ItemRepository;
import com.magazyn.magazynserver.service.ItemService;
import com.magazyn.magazynserver.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;

@SpringBootTest
public class ItemServiceTest {

    @Mock
    private ItemRepository items;

    @Autowired
    ItemServiceImpl itemService;
    Item item;

    @BeforeEach
    void init() {
        item = new Item();
        item.setItemId(1l);
        Mockito.when(items.findAllById(any())).thenReturn(List.of(item));
    }

    @Test
    void getUser_userReturned() {
        Item tested = itemService.getItemById(1l).get(0);
        Assertions.assertEquals("Paiting", tested.getName());
    }

}

