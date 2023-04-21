package com.magazyn.magazynserver.data.repository;

import com.magazyn.magazynserver.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long itemId);

}
