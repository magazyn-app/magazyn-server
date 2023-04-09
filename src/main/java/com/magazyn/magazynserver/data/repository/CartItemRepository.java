package com.magazyn.magazynserver.data.repository;

import com.magazyn.magazynserver.data.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findCartItemByCartItemId(Long id);
    CartItem findCartItemByCartId(Long id);
    CartItem findCartItemByItemId(Long id);
}
