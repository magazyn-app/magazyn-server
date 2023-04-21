package com.magazyn.magazynserver.data.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
