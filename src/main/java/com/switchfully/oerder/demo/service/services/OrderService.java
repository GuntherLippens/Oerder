package com.switchfully.oerder.demo.service.services;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.business.repositories.ItemCrudRepository;
import com.switchfully.oerder.demo.business.repositories.OrderCrudRepository;
import com.switchfully.oerder.demo.service.dtos.items.OrderOverviewDTO;
import com.switchfully.oerder.demo.utilities.OrderStatus;
import com.switchfully.oerder.demo.business.repositories.OrderRepository;
import com.switchfully.oerder.demo.exceptions.items.OrderNotFoundException;
import com.switchfully.oerder.demo.service.dtos.items.OrderDTO;
import com.switchfully.oerder.demo.service.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderCrudRepository orderRepository;
    private final ItemCrudRepository itemRepository;
    private final OrderMapper     orderMapper;

    @Autowired
    public OrderService(
                    OrderCrudRepository orderRepository,
                    ItemCrudRepository  itemRepository,
                    OrderMapper     orderMapper) {
        this.orderRepository = orderRepository;
        this.itemRepository  = itemRepository;
        this.orderMapper     = orderMapper;
    }

    public List<OrderDTO> getAllOrderDTOs() {
        return ((List<Order>)orderRepository.findAll())
                              .stream()
                              .map(orderMapper::detailDTO)
                              .collect(Collectors.toList());
    }

    public List<OrderDTO> getAllMyOrderDTOs(int customerId) {
        return ((List<Order>)orderRepository.findAll())
                .stream()
                .map(orderMapper::detailDTO)
                .filter(orderDTO -> orderDTO.getCustomerId() == customerId)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderDetailsById(Order order) {
        return orderMapper.detailDTO(orderRepository.findById(order.getOrderId()).get());

    }

    public OrderDTO registerOrder(OrderDTO orderDTO) {
        Order order = orderRepository.save(orderMapper.createOrder(orderDTO));
        return orderMapper.detailDTO(order);
    }

    public OrderDTO placeOrder(Order order) {
        updateStocksDueToOrdering(order);
        order.setOrderStatus(OrderStatus.ORDERED);
        return orderMapper.detailDTO(order);
    }

    public OrderDTO reorderOldOrder(int oldOrderId) {
        Order clonedOrder = cloneOrderWhichHasAdaptedPricesForItemGroups(oldOrderId);
        orderRepository.save(clonedOrder);
        updateStocksDueToOrdering(clonedOrder);
        clonedOrder.setOrderStatus(OrderStatus.ORDERED);
        return orderMapper.detailDTO(clonedOrder);
    }

    private void updateStocksDueToOrdering (Order order) {
        order.getItemGroups()
             .forEach(itemGroup -> {
                    int orderedAmount = itemGroup.getAmount();
                    Optional<Item> item = itemRepository.findById(itemGroup.getItem().getItemId());
                    int amountInStock = item.get().getAmount();
                    int newStockAfterOrderPlacement = amountInStock - orderedAmount;
                    item.get().setAmount(newStockAfterOrderPlacement);
        });

    }

    public OrderOverviewDTO makeAnOrderSummaryForACustomer(int customerId){
        return new OrderOverviewDTO(getAllMyOrderDTOs(customerId));
    }

    public Order cloneOrderWhichHasAdaptedPricesForItemGroups(int orderId){
        Order oldOrder = orderRepository.findById(orderId).get();
        Order newOrder = new Order(oldOrder);
        newOrder.getItemGroups()
                .forEach(itemGroup -> itemGroup.setOrderPrice(
                        itemRepository.findById(itemGroup
                                .getItem()
                                .getItemId())
                                .get()
                                .getPrice()));
        return newOrder;
    }


}
