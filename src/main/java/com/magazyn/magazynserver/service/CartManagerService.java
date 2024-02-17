package com.magazyn.magazynserver.service;

import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.data.object.AddUserItemResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CartManagerService {

    List<UserItem> userCart(String userId);

    Integer deleteCart(String userId);

    Integer deleteItemEntry(String userId, String itemId);

    Integer deleteItem(String userId, String itemId);

    AddUserItemResponse addNewItem(String userID, String itemId);
}
