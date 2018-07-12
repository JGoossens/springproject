package be.kdg.springproject.dom.shopping;

import be.kdg.springproject.dom.stock.Product;

import javax.persistence.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Table
public class Cart
{
    @Id
    @GeneratedValue
    @Column(name = "CART_ID", nullable = false)
    private Integer cartId;

    @OneToMany(targetEntity = CartItem.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="cart")
    private final Map<Integer, CartItem> cartItems;

    public Cart()
    {
        this.cartItems = new ConcurrentHashMap<>();
    }



    public Map<Integer, CartItem> getCartItems()
    {
        return this.cartItems;
    }

    /**
     * Hiermee kan je een product toevoegen of verwijderen uit het
     * winkelkarretje.
     *
     * @param amount  kan dus ook een negatieve getal zijn.
     * @param product
     * @param amount
     */
    public void updateProduct(final Product product, final Integer amount)
    {
        CartItem cartItem;

        if (cartItems.keySet().contains(product))
        {
            cartItem = cartItems.get(product);
            int newAmount = cartItem.getAmount() + amount;
            if (newAmount > 0)
            {
                // cartItem is final daarom constructor aanroepen
                cartItem = new CartItem(this, product, newAmount);
                cartItems.put(product.getProductId(), cartItem);
            }
            else
                cartItems.remove(product);
        }
        else
        {
            cartItem = new CartItem(this, product, amount);
            cartItems.put(product.getProductId(), cartItem);
        }
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Double getTotalPrice()
    {
        Double sum = 0.0d;
        for (CartItem cartItem : cartItems.values())
        {
            sum += cartItem.getPrice();
        }
        return sum;
    }

    public int getCartItemAmount(Product product)
    {
        if (cartItems.containsKey(product))
            return this.cartItems.get(product).getAmount();
        return 0;
    }

    public void clearCart()
    {
        cartItems.clear();
    }
}