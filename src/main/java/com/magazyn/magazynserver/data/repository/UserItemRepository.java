package com.magazyn.magazynserver.data.repository;

import com.magazyn.magazynserver.data.model.UserItem;
import com.magazyn.magazynserver.data.object.UserItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserItemRepository extends JpaRepository<UserItem, Long> {

    UserItem findUserItemEntryByUserId(Long id);

    List<UserItem> findUserItemEntriesByUserId(Long id);

    @Query("select ui.quantity, i.name, i.price, i.type from UserItem ui inner join Item i on ui.itemId = i.itemId where ui.userId = :id")
    List<UserItemDetails> findUserCart(Long id);
}
