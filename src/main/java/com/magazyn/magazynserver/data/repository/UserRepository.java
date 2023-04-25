package com.magazyn.magazynserver.data.repository;

import com.magazyn.magazynserver.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
