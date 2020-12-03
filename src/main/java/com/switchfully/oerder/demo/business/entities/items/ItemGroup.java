package com.switchfully.oerder.demo.business.entities.items;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="item_group")
public class ItemGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemGroupId;
    @OneToOne
    @JoinColumn(name="order_id")
    private Order order;

    @OneToOne
    @JoinColumn(name="item_id")
    private Item item;

    @Column(name="amount")
    private int amount;

    @Column(name="order_price")
    private double orderPrice;

    @Column(name="shipping_date")
    private LocalDate shippingDate;


    public ItemGroup(Order order, Item item, int amount, double orderPrice, LocalDate shippingDate) {
        this.order = order;
        this.item = item;
        this.amount = amount;
        this.orderPrice = orderPrice;
        this.shippingDate = shippingDate;
    }

    public ItemGroup() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrderId(Order orderId) {
        this.order = orderId;
    }

    public int getItemGroupId() {
        return itemGroupId;
    }

    public void setItemGroupId(int itemGroupId) {
        this.itemGroupId = itemGroupId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemGroup)) return false;
        ItemGroup itemGroup = (ItemGroup) o;
        return getItemGroupId() == (itemGroup.getItemGroupId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemGroupId());
    }
}
