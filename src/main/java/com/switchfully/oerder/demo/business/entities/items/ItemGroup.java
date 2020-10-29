package com.switchfully.oerder.demo.business.entities.items;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private String orderGroupId;
    private String itemGroupId;
    private String itemId;
    private int amount;
    private double orderPrice;
    private LocalDate shippingDate;

    public ItemGroup(String orderGroupId, String itemId, int amount, double orderPrice, LocalDate shippingDate) {
        this.orderGroupId = orderGroupId;
        this.itemId = itemId;
        this.amount = amount;
        this.orderPrice = orderPrice;
        this.shippingDate = shippingDate;
        this.itemGroupId = UUID.randomUUID().toString();
    }

    public String getOrderGroupId() {
        return orderGroupId;
    }

    public void setOrderGroupId(String orderGroupId) {
        this.orderGroupId = orderGroupId;
    }

    public String getItemGroupId() {
        return itemGroupId;
    }

    public void setItemGroupId(String itemGroupId) {
        this.itemGroupId = itemGroupId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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
}
