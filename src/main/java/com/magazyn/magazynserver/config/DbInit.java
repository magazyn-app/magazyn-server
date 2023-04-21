package com.magazyn.magazynserver.config;

import com.magazyn.magazynserver.data.model.User;
import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.data.repository.UserItemRepository;
import com.magazyn.magazynserver.data.repository.UserRepository;
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
    List<User> initUsers;
    List<Item> initItems;

    public DbInit(ItemRepository items, UserRepository users, UserItemRepository cartItems) {
        this.items = items;
        this.users = users;
        this.cartItems = cartItems;
        initUsers = generateUsers();
        initItems = generateItems();
    }

    @PostConstruct
    public void init() {
        items.saveAll(initItems);
        users.saveAll(generateUsers());
        initUserItems();
    }

    private void initUserItems() {
        List<UserItem> toAdd = List.of(
                new UserItem(null, initUsers.get(0), initItems.get(0), 1),
                new UserItem(null, initUsers.get(0), initItems.get(1), 1),
                new UserItem(null, initUsers.get(0), initItems.get(2), 1),
                new UserItem(null, initUsers.get(0), initItems.get(3), 1),
                new UserItem(null, initUsers.get(0), initItems.get(4), 1),
                new UserItem(null, initUsers.get(1), initItems.get(1), 2),
                new UserItem(null, initUsers.get(1), initItems.get(0), 2),
                new UserItem(null, initUsers.get(1), initItems.get(4), 2),
                new UserItem(null, initUsers.get(0), initItems.get(5), 2));

        cartItems.saveAll(toAdd);
    }

    private List<User> generateUsers() {
        return List.of(
                new User(null, "John", "Doe@test.com", "pass1"),
                new User(null, "Test", "admin@test.com", "pass2"),
                new User(null, "Lets", "Go", "pass3"));
    }

    private List<Item> generateItems() {
        return  List.of(
                new Item(null, "Paiting", 420.69, ItemType.ART),
                new Item(null, "Jacket", 200.00, ItemType.CLOTHES),
                new Item(null, "iPhone 20", 100394.10, ItemType.ELECTRONICS),
                new Item(null, "water", 69.69, ItemType.FOOD),
                new Item(null, "CD Elton John", 19.80, ItemType.MUSIC),
                new Item(null, "Football", 30.50, ItemType.SPORT));
    }
}

