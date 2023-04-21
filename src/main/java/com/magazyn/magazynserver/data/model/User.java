package com.magazyn.magazynserver.data.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;
    private String name;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_items", referencedColumnName = "id")
    private List<UserItem> userItems;

    public User(Long id, String name, String email, String password) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
