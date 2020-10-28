package com.switchfully.oerder.demo.business.entities.items;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<ItemGroup> itemGroups;
    private String customerId;
    private double totalPrice;

    public Order(String customerId) {
        this.customerId = customerId;
        this.itemGroups = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }

    public void addItemGroup(ItemGroup itemGroup) {
        itemGroups.add(itemGroup);
        totalPrice += itemGroup.getOrderPrice() * itemGroup.getAmount();
    }

    public String getId() {
        return id;
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
}
