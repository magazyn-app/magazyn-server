package com.magazyn.magazynserver.service.impl;

import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.service.OrderManagerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderManagerServiceImpl implements OrderManagerService {

    List<UserItem> userItems;

}
