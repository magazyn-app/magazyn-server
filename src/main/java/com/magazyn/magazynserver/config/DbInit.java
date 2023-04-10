package com.magazyn.magazynserver.config;

import com.magazyn.magazynserver.data.model.Cart;
import com.magazyn.magazynserver.data.model.CartItem;
import com.magazyn.magazynserver.data.repository.CartItemRepository;
import com.magazyn.magazynserver.data.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.data.object.ItemType;
import com.magazyn.magazynserver.data.repository.ItemRepository;

import jakarta.annotation.PostConstruct;

import java.util.List;

@Component
public class DbInit {

    private final ItemRepository items;
    private final CartRepository carts;
    private final CartItemRepository cartItems;

    @Autowired
    public DbInit(ItemRepository items, CartRepository carts, CartItemRepository cartItems) {
        this.items = items;
        this.carts = carts;
        this.cartItems = cartItems;
    }

    @PostConstruct
    public void init() {
        initItems();
        initCarts();
        initCartItems();
    }

    private void initItems() {
        List<Item> toAdd = List.of(
                new Item(null, "Paiting", 420.69, ItemType.ART),
                new Item(null, "Jacket", 200.00, ItemType.CLOTHES),
                new Item(null, "iPhone 20", 100394.10, ItemType.ELECTRONICS),
                new Item(null, "water", 69.69, ItemType.FOOD),
                new Item(null, "Elton John", 19.80, ItemType.MUSIC),
                new Item(null, "Football", 30.50, ItemType.SPORT));

        items.saveAll(toAdd);
    }

    private void initCarts() {
        List<Cart> toAdd = List.of(
                new Cart(1L, 1L),
                new Cart(2L, 2L));

        carts.saveAll(toAdd);
    }

    private void initCartItems() {
        List<CartItem> toAdd = List.of(
                new CartItem(1L, 1L, 1L, 1),
                new CartItem(1L, 1L, 2L, 1),
                new CartItem(1L, 1L, 3L, 1),
                new CartItem(1L, 1L, 4L, 1),
                new CartItem(1L, 1L, 5L, 1),
                new CartItem(2L, 2L, 2L, 2),
                new CartItem(2L, 2L, 1L, 2),
                new CartItem(2L, 2L, 5L, 2),
                new CartItem(2L, 3L, 6L, 2));

        cartItems.saveAll(toAdd);
    }
}

