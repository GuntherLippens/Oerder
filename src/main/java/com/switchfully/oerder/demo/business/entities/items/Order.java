package com.switchfully.oerder.demo.business.entities.items;

import com.switchfully.oerder.demo.business.entities.users.Customer;
import com.switchfully.oerder.demo.utilities.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @OneToMany
    @JoinColumn(name="order_id")
    private List<ItemGroup> itemGroups;

    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="total_price")
    private double totalPrice;

    @Enumerated(value = EnumType.STRING)
    @Column(name="order_status")
    private OrderStatus orderStatus;

    public Order(Customer customer) {
        this.customer = customer;
        this.itemGroups = new ArrayList<>();
        this.orderStatus = OrderStatus.CREATED;
    }

    public Order(Order order) {
        this.customer = order.getCustomer();
        this.itemGroups = order.getItemGroups();
        this.orderId    = order.getOrderId();
        this.orderStatus= order.getOrderStatus();
        this.totalPrice = order.getTotalPrice();
    }

    public Order() {
    }

    public void addItemGroup(ItemGroup itemGroup) {
        itemGroups.add(itemGroup);
        totalPrice += itemGroup.getOrderPrice() * itemGroup.getAmount();
    }

    public int getOrderId() {
        return orderId;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public void setItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getOrderId() == (order.getOrderId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId());
    }
}
