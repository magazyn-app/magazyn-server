package com.magazyn.magazynserver.data.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.magazyn.magazynserver.data.object.ItemType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonAutoDetect
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long itemId;
    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private ItemType type;

    public Item(Long itemId, String name, Double price, ItemType type) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
