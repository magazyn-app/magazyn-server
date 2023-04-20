package com.magazyn.magazynserver.service.impl;

import com.magazyn.magazynserver.data.object.UserItemDetails;
import com.magazyn.magazynserver.data.repository.UserItemRepository;
import com.magazyn.magazynserver.service.CartManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartManagerServiceImpl implements CartManagerService {

    UserItemRepository userItemRepository;

    @Autowired
    public CartManagerServiceImpl(UserItemRepository userItemRepository) {
        this.userItemRepository = userItemRepository;
    }

    @Override
    public List<UserItemDetails> userCart() {
        return userItemRepository.findUserCart(1L);
    }
}
