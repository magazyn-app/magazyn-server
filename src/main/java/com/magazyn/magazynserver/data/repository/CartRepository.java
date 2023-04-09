package com.magazyn.magazynserver.data.repository;

import com.magazyn.magazynserver.data.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findCartByCartId(Long cartId);
}
