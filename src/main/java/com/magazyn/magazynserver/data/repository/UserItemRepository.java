package com.magazyn.magazynserver.data.repository;

import com.magazyn.magazynserver.data.model.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface UserItemRepository extends JpaRepository<UserItem, Long> {
    UserItem findUserItemEntryByUserEntryId(Long id);


    UserItem findUserItemEntryByUserId(Long id);

    List<UserItem> findUserItemEntriesByUserId(Long id);
}
