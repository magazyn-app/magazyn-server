package com.magazyn.magazynserver.service.impl;

import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.data.repository.UserItemRepository;
import com.magazyn.magazynserver.service.CartManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Integer deleteCart(String userId) {
        return responseStatus(userItemRepository.deleteUserItemsByUserId(Long.valueOf(userId)));
    }

    @Override
    public Integer deleteItemEntry(String userId, String itemId) {
        return responseStatus(userItemRepository.deleteItemEntry(Long.valueOf(userId), Long.valueOf(itemId)));
    }

    private Integer responseStatus(int result) {
        if (result > 0){
            return HttpStatus.OK.value();
        }
        return HttpStatus.EXPECTATION_FAILED.value();
    }
}
