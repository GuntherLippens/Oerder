package com.switchfully.oerder.demo.service.dtos.items;

import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.business.entities.users.Customer;
import com.switchfully.oerder.demo.utilities.OrderStatus;

import java.util.List;

public class OrderDTO {

    private int customerId;
    private double totalPrice;
    private OrderStatus orderIsPlaced;






    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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
