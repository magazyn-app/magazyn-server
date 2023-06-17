package com.magazyn.magazynserver.data.object;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddUserItemResponse {
    private long userId;
    private long itemId;
    private int quantity;
}
