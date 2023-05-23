package com.magazyn.magazynserver.service;

import com.magazyn.magazynserver.data.model.UserItem;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CartManagerService {

    List<UserItem> userCart(String userId);

    Integer deleteCart(String userId);

}
