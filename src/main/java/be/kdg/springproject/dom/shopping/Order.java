package be.kdg.springproject.dom.shopping;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "ORDERS")
public class Order
{

    @Id
    @GeneratedValue
    @Column(name = "OrderId", nullable = false)
    private Integer orderId;

    @OneToMany(targetEntity = LineItem.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<LineItem> lineItems;

    @Column
    private LocalDateTime orderDate;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setLineItems(Collection<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Order()
    {
        orderDate = LocalDateTime.now();
        lineItems = new ArrayList<LineItem>();
    }

    /**
     * Bereken de totale prijs voor die order.
     *
     * @return
     */
    public double getTotalPrice()
    {
        double totalPrice = 0.0d;
        for (LineItem lineItem : lineItems)
            totalPrice += lineItem.getPrice();
        return totalPrice;
    }

    /**
     * @return
     */
    public LocalDateTime getOrderDate()
    {
        return this.orderDate;
    }

    public Collection<LineItem> getLineItems()
    {
        return lineItems;
    }

    public synchronized void addLineItem(LineItem lineItem)
    {
        this.lineItems.add(lineItem);
    }

}