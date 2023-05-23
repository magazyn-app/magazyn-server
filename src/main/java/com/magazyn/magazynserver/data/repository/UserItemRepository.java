package com.magazyn.magazynserver.data.repository;

import com.magazyn.magazynserver.data.model.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
@Repository
public interface UserItemRepository extends JpaRepository<UserItem, Long> {

    List<UserItem> findUserItemByUserId(Long id);

    @Modifying
    @Query("delete from UserItem u where u.user.id = :userId")
    int deleteUserItemsByUserId(@Param("userId") Long userId);
}
