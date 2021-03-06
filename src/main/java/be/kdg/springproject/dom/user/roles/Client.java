package be.kdg.springproject.dom.user.roles;

import be.kdg.springproject.dom.shopping.Cart;
import be.kdg.springproject.dom.shopping.CartItem;
import be.kdg.springproject.dom.shopping.LineItem;
import be.kdg.springproject.dom.shopping.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A Client can post repairs to the system.
 *
 * @author wouter
 */
@Entity
@DiscriminatorValue("ROLE_CLIENT")
public class Client extends Role {
    @OneToOne(targetEntity = Cart.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        return authorities;
    }

    @Override
    public RoleType getRoleType() {
        return RoleType.ROLE_CLIENT;
    }

}
