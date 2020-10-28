package com.switchfully.oerder.demo.business.entities.items;

import com.switchfully.oerder.demo.business.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ItemGroup {
    private String id;
    private int amount;
    private double orderPrice;
    private LocalDate shippingDate;

    public ItemGroup(String id, int amount, double orderPrice, LocalDate shippingDate) {
        this.id = id;
        this.amount = amount;
        this.orderPrice = orderPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
