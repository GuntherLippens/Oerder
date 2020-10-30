package com.switchfully.oerder.demo.business.repositories;

import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.exceptions.items.OrderAlreadyExistsException;
import com.switchfully.oerder.demo.exceptions.items.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    private final Map<String, Order> orders;

    @Autowired
    public OrderRepository() {
        this.orders = new HashMap<>();
    }

    public Order save(Order order) {
        if (orders.containsValue(order)) {
            throw new OrderAlreadyExistsException(order.getOrderId());
        }
        orders.put(order.getOrderId(), order);

        return order;
    }

    public Order getOrder(String orderId) {
        Order item = orders.get(orderId);
        if (Objects.isNull(item)) {
            throw new OrderNotFoundException(orderId);
        }
        return item;
    }

    public Map<String, Order> getOrderMap() {
        return orders;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }



}

