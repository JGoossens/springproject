package be.kdg.springproject.services.impl;

import be.kdg.springproject.dom.shopping.Cart;
import be.kdg.springproject.dom.shopping.CartItem;
import be.kdg.springproject.persistence.api.CartItemRepository;
import be.kdg.springproject.persistence.api.CartRepository;
import be.kdg.springproject.services.api.CartService;
import be.kdg.springproject.services.exceptions.CartServiceException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    CartItemRepository cartItemRepo;
    CartRepository cartRepo;

    @Autowired
    public CartServiceImpl(final CartItemRepository cartItemRepo, final CartRepository cartRepo) {
        this.cartItemRepo = cartItemRepo;
        this.cartRepo = cartRepo;
    }

    @Override
    public Cart findCartById(Integer cartId) {
        Cart cart = cartRepo.findById(cartId).get();
        if(cart == null){
            throw new CartServiceException("Cart not found");
        }

        return cart;
    }

    @Override
    public CartItem findCartItemById(Integer cartItemId) {
        CartItem cartItem = cartItemRepo.findById(cartItemId).get();
        if(cartItem == null){
            throw new CartServiceException("CartItem not found");
        }

        return cartItem;
    }
}
