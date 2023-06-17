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

    @Modifying
    @Query("delete from UserItem u where u.user.id = :userId and u.item.itemId = :itemId")
    int deleteItemEntry(@Param("userId") Long userId, @Param("itemId") Long itemId);

    @Modifying
    @Query("update UserItem u set u.quantity = u.quantity-1 where u.user.id = :userId and u.item.itemId = :itemId")
    int deleteItem(@Param("userId") Long userId, @Param("itemId") Long itemId);

    @Modifying
    @Query("delete from UserItem u where u.user.id = :userId and u.item.itemId = :itemId and u.quantity<1")
    int itemsPrune(@Param("userId") Long userId, @Param("itemId") Long itemId);

    UserItem findUserItemByItem_ItemIdAndUser_Id(long itemId, long userId);
}
