package be.kdg.springproject.services.api;

import be.kdg.springproject.dom.shopping.Cart;
import be.kdg.springproject.dom.shopping.CartItem;

import javax.transaction.Transactional;

@Transactional
public interface CartService {
    Cart findCartById(Integer cartId);
    CartItem findCartItemById(Integer cartItemId);
}
