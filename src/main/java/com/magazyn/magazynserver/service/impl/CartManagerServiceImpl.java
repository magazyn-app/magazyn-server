package com.magazyn.magazynserver.service.impl;

import com.magazyn.magazynserver.data.model.Item;
import com.magazyn.magazynserver.data.model.User;
import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.data.object.AddUserItemResponse;
import com.magazyn.magazynserver.data.repository.UserItemRepository;
import com.magazyn.magazynserver.data.repository.UserRepository;
import com.magazyn.magazynserver.data.repository.ItemRepository;
import com.magazyn.magazynserver.service.CartManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CartManagerServiceImpl implements CartManagerService {

    private final UserItemRepository userItemRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Autowired
    public CartManagerServiceImpl(UserItemRepository userItemRepository, ItemRepository itemRepository, UserRepository userRepository) {
        this.userItemRepository = userItemRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
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

    @Override
    public Integer deleteItem(String userId, String itemId) {
        int response = userItemRepository.deleteItem(Long.valueOf(userId), Long.valueOf(itemId));
        int deleted = userItemRepository.itemsPrune(Long.valueOf(userId), Long.valueOf(itemId));

        if (response > 0 && deleted > 0) {
            return HttpStatus.ACCEPTED.value();
        } else if (response > 0) {
            return HttpStatus.OK.value();
        }

        return HttpStatus.EXPECTATION_FAILED.value();
    }

    @Override
    public AddUserItemResponse addNewItem(String userId, String itemId) {
        long userLongId = Long.parseLong(userId);
        long itemLongId = Long.parseLong(itemId);
        UserItem userItem = userItemRepository.findUserItemByItem_ItemIdAndUser_Id(itemLongId, userLongId);

        if (userItem == null) {
            userItem = new UserItem();
            Item item = itemRepository.findById(itemLongId).orElseThrow();
            User user = userRepository.findById(userLongId).orElseThrow();
            userItem.setItem(item);
            userItem.setUser(user);
            userItem.setQuantity(1);
            userItemRepository.save(userItem);

            return new AddUserItemResponse(user.getId(), item.getItemId(), 1);
        }

        userItem.setQuantity(userItem.getQuantity() + 1);
        userItemRepository.save(userItem);

        return new AddUserItemResponse(userItem.getUser().getId(), userItem.getItem().getItemId(), userItem.getQuantity());
    }

    private Integer responseStatus(int result) {
        if (result > 0) {
            return HttpStatus.OK.value();
        }
        return HttpStatus.EXPECTATION_FAILED.value();
    }
}
