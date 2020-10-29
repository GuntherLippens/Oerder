package com.switchfully.oerder.demo.business.entities.items;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private List<ItemGroup> itemGroups;
    private String customerId;
    private double totalPrice;
    private boolean orderIsPlaced;

    public Order(String customerId) {
        this.customerId = customerId;
        this.itemGroups = new ArrayList<>();
        this.orderId = UUID.randomUUID().toString();
        this.orderIsPlaced = false;
    }

    public void addItemGroup(ItemGroup itemGroup) {
        itemGroups.add(itemGroup);
        totalPrice += itemGroup.getOrderPrice() * itemGroup.getAmount();
    }

    public String getOrderId() {
        return orderId;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public void setItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isOrderIsPlaced() {
        return orderIsPlaced;
    }

    public void setOrderIsPlaced(boolean orderIsPlaced) {
        this.orderIsPlaced = orderIsPlaced;
    }
}
