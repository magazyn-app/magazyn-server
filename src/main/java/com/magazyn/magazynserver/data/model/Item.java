package com.magazyn.magazynserver.data.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.magazyn.magazynserver.data.object.ItemType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
