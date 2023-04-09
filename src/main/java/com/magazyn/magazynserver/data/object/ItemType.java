package com.magazyn.magazynserver.data.object;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemType {
    FOOD("food"),
    SPORT("sport"),
    GAY("gay");

    private final String itemType;
}
