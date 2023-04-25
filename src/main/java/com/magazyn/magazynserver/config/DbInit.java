package com.magazyn.magazynserver.config;

import com.magazyn.magazynserver.data.model.User;
import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.data.repository.UserItemRepository;
import com.magazyn.magazynserver.data.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.data.object.ItemType;
import com.magazyn.magazynserver.data.repository.ItemRepository;


import java.util.List;

@Component
public class DbInit {

    private final ItemRepository items;
    private final UserRepository users;
    private final UserItemRepository cartItems;
    private final List<Item> generatedItems;
    private final List<User> generatedUsers;
    private final List<UserItem> generatedUserItems;

    @Autowired
    public DbInit(ItemRepository items, UserRepository users, UserItemRepository cartItems) {
        this.items = items;
        this.users = users;
        this.cartItems = cartItems;
        this.generatedItems = initItems();
        this.generatedUsers = initUsers();
        this.generatedUserItems = initUserItems();
    }

    @PostConstruct
    public void init() {
        items.saveAll(generatedItems);
        users.saveAll(generatedUsers);
        cartItems.saveAll(generatedUserItems);
    }

    private List<Item> initItems() {
        return List.of(
                new Item(null, "Paiting", 420.69, ItemType.ART),
                new Item(null, "Jacket", 200.00, ItemType.CLOTHES),
                new Item(null, "iPhone 20", 100394.10, ItemType.ELECTRONICS),
                new Item(null, "water", 69.69, ItemType.FOOD),
                new Item(null, "CD Elton John", 19.80, ItemType.MUSIC),
                new Item(null, "Football", 30.50, ItemType.SPORT));

    }

    private List<User> initUsers() {
        return List.of(
                new User(null, "John", "Doe@test.com", "pass1"),
                new User(null, "Test", "admin@test.com", "pass2"),
                new User(null, "Lets", "Go", "pass3"));
    }

    private List<UserItem> initUserItems() {
        return List.of(
                new UserItem(null, generatedItems.get(0), generatedUsers.get(0), 1),
                new UserItem(null, generatedItems.get(1), generatedUsers.get(0), 1),
                new UserItem(null, generatedItems.get(2), generatedUsers.get(0), 1),
                new UserItem(null, generatedItems.get(3), generatedUsers.get(0), 1),
                new UserItem(null, generatedItems.get(4), generatedUsers.get(0), 1),
                new UserItem(null, generatedItems.get(1), generatedUsers.get(1), 2),
                new UserItem(null, generatedItems.get(0), generatedUsers.get(1), 2),
                new UserItem(null, generatedItems.get(4), generatedUsers.get(1), 2),
                new UserItem(null, generatedItems.get(5), generatedUsers.get(2), 2));
    }
}

