package com.switchfully.oerder.demo.service.dtos.items;

import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.business.entities.items.OrderStatus;

import java.util.List;

public class OrderDTO {
    private String orderId;
    private List<ItemGroup> itemGroups;
    private String customerId;
    private double totalPrice;
    private OrderStatus orderIsPlaced;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public OrderStatus getOrderStatus() {
        return orderIsPlaced;
    }

    public void setOrderStatus(OrderStatus orderIsPlaced) {
        this.orderIsPlaced = orderIsPlaced;
    }
}
