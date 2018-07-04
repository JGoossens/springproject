package be.kdg.springproject.dom.shopping;

import be.kdg.springproject.dom.stock.Product;

import javax.persistence.*;

@Entity
@Table
public class CartItem
{
    @Id
    @GeneratedValue
    @Column(name = "CartItemId", nullable = false)
    private Integer cartItemId;

    @OneToOne(targetEntity = Product.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductId")
    private Product product;

    @ManyToOne(targetEntity = Cart.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="CartId",nullable = false)
    private Cart cart;

    @Column(name="Amount",nullable = false)
    private Integer amount;

    public CartItem() {
        this.amount= 0;
    }

    public CartItem(Cart cart, Product product, Integer amount)
    {
        this.cart = cart;
        this.product = product;
        this.amount = amount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice()
    {
        return this.product.getPrice() * this.getAmount();
    }

    public Integer getAmount()
    {
        return this.amount;
    }

    public Product getProduct()
    {
        return this.product;
    }
}