package com.magazyn.magazynserver.service;

import com.magazyn.magazynserver.data.object.UserItemDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartManagerService {

    List<UserItemDetails> userCart();

}
