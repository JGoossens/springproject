package be.kdg.springproject.model.user.roles;

import be.kdg.springproject.model.shopping.Cart;
import be.kdg.springproject.model.shopping.CartItem;
import be.kdg.springproject.model.shopping.LineItem;
import be.kdg.springproject.model.shopping.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A Client can post repairs to the system.
 *
 * @author wouter
 */
public class Client extends Role {
    private Cart cart;
    private Collection<Order> orders;

    public Client() {
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

    public Order createOrder()
    {
        Order order = new Order();
        for (CartItem cartItem : getCart().getCartItems().values())
        {
            order.addLineItem(new LineItem(cartItem.getProduct().getDescription(), cartItem.getAmount(), cartItem.getPrice()));
        }
        getCart().clearCart();
        synchronized (this)
        {
            orders.add(order);
        }
        return order;
    }

    public Cart getCart()
    {
        return cart;
    }

    public synchronized void setCart(Cart cart)
    {
        this.cart = cart;
    }

    public Collection<Order> getOrders()
    {
        return orders;
    }

    public synchronized void setOrders(Collection<Order> orders)
    {
        this.orders = orders;
    }


    @Override
    public RoleType getRoleType() {
        return RoleType.ROLE_CLIENT;
    }

}
