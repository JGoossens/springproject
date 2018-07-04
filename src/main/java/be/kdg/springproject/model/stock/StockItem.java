package be.kdg.springproject.model.stock;

import javax.persistence.*;

@Entity
@Table
public class StockItem
{
    @Id
    @GeneratedValue
    @Column(name = "StockItemId", nullable = false)
    private Integer stockItemId;

    @Column
    private Integer amount;

    @OneToOne(targetEntity = Product.class)
    @JoinColumn(name = "ProductId")
    private Product product;


    public StockItem() {
    }

    public StockItem(Integer amount)
    {
        this.amount = amount;
    }

    /**
     * Geef de hoeveelheid weer voor dit stockitem
     *
     * @return
     */
    public Integer getAmount()
    {
        return this.amount;
    }

    public Integer getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Integer stockItemId) {
        this.stockItemId = stockItemId;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}