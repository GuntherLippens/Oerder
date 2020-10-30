package com.switchfully.oerder.demo.service.dtos.items;

import com.switchfully.oerder.demo.business.entities.items.Order;

import java.util.List;


public class OrderOverviewDTO {
    private List<OrderDTO> orders;
    private double totalPrice;

    public OrderOverviewDTO(List<OrderDTO> orders) {
        this.orders = orders;
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        orders.stream().forEach(orderDTO -> totalPrice += orderDTO.getTotalPrice());
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
