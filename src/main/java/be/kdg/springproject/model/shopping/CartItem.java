package be.kdg.springproject.model.shopping;

import be.kdg.springproject.model.stock.Product;

public final class CartItem
{
    private final Product product;
    private final Integer amount;

    public CartItem(Product product, Integer amount)
    {
        this.product = product;
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