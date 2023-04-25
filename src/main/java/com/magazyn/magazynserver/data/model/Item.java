package com.magazyn.magazynserver.data.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.magazyn.magazynserver.data.object.ItemType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private String name;
    private Double price;
    @Enumerated(EnumType.STRING)
    private ItemType type;

}
