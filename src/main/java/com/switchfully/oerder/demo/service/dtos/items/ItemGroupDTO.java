package com.switchfully.oerder.demo.service.dtos.items;

import java.time.LocalDate;

public class ItemGroupDTO {
    private String orderId;
    private String itemGroupId;
    private String itemId;
    private int amount;
    private double orderPrice;
    private LocalDate shippingDate;

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getItemGroupId() {
        return itemGroupId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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


}
