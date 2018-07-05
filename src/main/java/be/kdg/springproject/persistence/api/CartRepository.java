package be.kdg.springproject.persistence.api;

import be.kdg.springproject.dom.shopping.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
