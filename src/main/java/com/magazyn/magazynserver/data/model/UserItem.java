package com.magazyn.magazynserver.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_entry_id")
    private Long userEntryId;
    private Long userId;
    private Long itemId;
    private Integer quantity;
}
