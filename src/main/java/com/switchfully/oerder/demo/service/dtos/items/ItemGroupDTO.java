package com.switchfully.oerder.demo.service.dtos.items;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.business.entities.items.Order;

import java.time.LocalDate;

public class ItemGroupDTO {
    private int orderId;

    private int itemId;
    private int amount;
    private double orderPrice;
    private LocalDate shippingDate;

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }



    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }



    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
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
