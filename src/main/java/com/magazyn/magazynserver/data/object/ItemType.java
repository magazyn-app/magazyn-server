package com.magazyn.magazynserver.data.object;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ItemType {
    ART("art"),
    CLOTHES("clothes"),
    ELECTRONICS("electronics"),
    FOOD("food"),
    MUSIC("music"),
    SPORT("sport");

    private final String itemType;
}
