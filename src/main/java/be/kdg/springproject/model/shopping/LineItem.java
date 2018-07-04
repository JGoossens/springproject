package be.kdg.springproject.model.shopping;

import javax.persistence.*;

@Entity
@Table
public class LineItem
{
    @Id
    @GeneratedValue
    @Column(name = "LineItemId", nullable = false)
    private Integer lineItemId;

    @Column
    private String productDescription;

    @Column
    private int amount;

    @Column
    private double price;

    public LineItem() {
    }

    public LineItem(String productDescription, int amount, double price)
    {
        this.productDescription = productDescription;
        this.amount = amount;
        this.price = price;
    }

    public Integer getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Integer lineItemId) {
        this.lineItemId = lineItemId;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    /**
     * @return
     */
    public int getAmount()
    {
        return amount;
    }

    /**
     * @return
     */
    public double getPrice()
    {
        return price;

    }

    public String getProductDescription()
    {
        return productDescription;
    }
}