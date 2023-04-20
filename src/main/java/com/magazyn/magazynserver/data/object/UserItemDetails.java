package com.magazyn.magazynserver.data.object;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect
public class UserItemDetails {
    private Integer quantity;
    private String name;
    private Double price;
    private ItemType type;
}
