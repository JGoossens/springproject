package be.kdg.springproject.persistence.api;

import be.kdg.springproject.dom.shopping.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
