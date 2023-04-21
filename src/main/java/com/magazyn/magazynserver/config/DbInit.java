package com.magazyn.magazynserver.config;

import com.magazyn.magazynserver.data.model.AppUser;
import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.data.repository.UserItemRepository;
import com.magazyn.magazynserver.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.data.object.ItemType;
import com.magazyn.magazynserver.data.repository.ItemRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DbInit {

    private final ItemRepository items;
    private final UserRepository users;
    private final UserItemRepository cartItems;

    @Autowired
    public DbInit(ItemRepository items, UserRepository users, UserItemRepository cartItems) {
        this.items = items;
        this.users = users;
        this.cartItems = cartItems;
    }

    @PostConstruct
    public void init() {
        initItems();
        initUsers();
        initUserItems();
    }

    private void initItems() {
        List<Item> toAdd = List.of(
                new Item(null, "Paiting", 420.69, ItemType.ART),
                new Item(null, "Jacket", 200.00, ItemType.CLOTHES),
                new Item(null, "iPhone 20", 100394.10, ItemType.ELECTRONICS),
                new Item(null, "water", 69.69, ItemType.FOOD),
                new Item(null, "CD Elton John", 19.80, ItemType.MUSIC),
                new Item(null, "Football", 30.50, ItemType.SPORT));

        items.saveAll(toAdd);
    }

    private void initUsers() {
        List<AppUser> toAdd = List.of(
                new AppUser(null, "John", "Doe@test.com", "pass1"),
                new AppUser(null, "Test", "admin@test.com", "pass2"),
                new AppUser(null, "Lets", "Go", "pass3"));

        users.saveAll(toAdd);
    }

    private void initUserItems() {
        List<UserItem> toAdd = List.of(
                new UserItem(null, 1L, 1L, 1),
                new UserItem(null, 1L, 2L, 1),
                new UserItem(null, 1L, 3L, 1),
                new UserItem(null, 1L, 4L, 1),
                new UserItem(null, 1L, 5L, 1),
                new UserItem(null, 2L, 2L, 2),
                new UserItem(null, 2L, 1L, 2),
                new UserItem(null, 2L, 5L, 2),
                new UserItem(null, 3L, 6L, 2));

        cartItems.saveAll(toAdd);
    }
}

