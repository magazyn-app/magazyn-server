package com.magazyn.magazynserver.service.impl;

import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.data.repository.UserItemRepository;
import com.magazyn.magazynserver.service.CartManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CartManagerServiceImpl implements CartManagerService {

    private final UserItemRepository userItemRepository;

    @Autowired
    public CartManagerServiceImpl(UserItemRepository userItemRepository) {
        this.userItemRepository = userItemRepository;
    }

    @Override
    public List<UserItem> userCart(String userId) {
        return userItemRepository.findUserItemByUserId(Long.valueOf(userId));
    }

    @Override
    public void deleteCart(String userId) {
        userItemRepository.deleteUserItemsByUserId(Long.valueOf(userId));
    }

}
