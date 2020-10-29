package com.switchfully.oerder.demo.business.entities.items;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class ItemGroup {
    private String orderId;
    private String itemGroupId;
    private String itemId;
    private int amount;
    private double orderPrice;
    private LocalDate shippingDate;

    public ItemGroup(String orderId, String itemId, int amount, double orderPrice, LocalDate shippingDate) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.amount = amount;
        this.orderPrice = orderPrice;
        this.shippingDate = shippingDate;
        this.itemGroupId = UUID.randomUUID().toString();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemGroup)) return false;
        ItemGroup itemGroup = (ItemGroup) o;
        return getItemGroupId().equals(itemGroup.getItemGroupId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemGroupId());
    }
}
