package com.switchfully.oerder.demo.business.repositories;

import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.exceptions.OrderAlreadyExistsException;
import com.switchfully.oerder.demo.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;


public class OrderRepository {

    private final Map<String, Order> orders;
    private final ItemRepository itemRepository;

    @Autowired
    public OrderRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.orders = new HashMap<>();
        addFirstOrder();
    }

    public Order save(Order order) {
        if (orders.containsValue(order))
            throw new OrderAlreadyExistsException(
                    "Order with id"
                            + order.getOrderId()
                            + " already exists.");
        orders.put(order.getOrderId(), order);

        return order;
    }

    public Order getOrder(String orderId) {
        Order item = orders.get(orderId);
        if (Objects.isNull(item)) {
            throw new OrderNotFoundException("There is no order available with the id " + orderId);
        }
        return item;
    }

    public Map<String, Order> getOrderMap() {
        return orders;
    }

    public void addFirstOrder() {
        Order order = new Order(
                "007default-item-group-id-points-to-nowhere-be-careful!",
                itemRepository.getFirstDefaultItem().getId(),
                10,
                6.66,
                LocalDate.now().plusYears(1000));

        orders.put(order.getOrderId(), order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

}
}
