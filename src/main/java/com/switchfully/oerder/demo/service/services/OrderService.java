package com.switchfully.oerder.demo.service.services;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.business.repositories.ItemRepository;
import com.switchfully.oerder.demo.service.dtos.items.OrderOverviewDTO;
import com.switchfully.oerder.demo.utilities.OrderStatus;
import com.switchfully.oerder.demo.business.repositories.OrderRepository;
import com.switchfully.oerder.demo.exceptions.items.OrderNotFoundException;
import com.switchfully.oerder.demo.service.dtos.items.OrderDTO;
import com.switchfully.oerder.demo.service.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository  itemRepository;
    private final OrderMapper     orderMapper;

    @Autowired
    public OrderService(
                    OrderRepository orderRepository,
                    ItemRepository  itemRepository,
                    OrderMapper     orderMapper) {
        this.orderRepository = orderRepository;
        this.itemRepository  = itemRepository;
        this.orderMapper     = orderMapper;
    }

    public List<OrderDTO> getAllOrderDTOs() {
        return orderRepository.getOrders()
                              .stream()
                              .map(orderMapper::detailDTO)
                              .collect(Collectors.toList());
    }

    public List<OrderDTO> getAllMyOrderDTOs(String customerId) {
        return orderRepository.getOrders()
                .stream()
                .map(orderMapper::detailDTO)
                .filter(order -> order.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderDetailsById(String id) {
        return orderMapper.detailDTO(orderRepository.getOrder(id));

    }

    public OrderDTO registerOrder(OrderDTO orderDTO) {
        Order order = orderRepository.save(orderMapper.createOrder(orderDTO));
        return orderMapper.detailDTO(order);
    }

    public OrderDTO placeOrder(String id) {
        if (!orderRepository.getOrderMap().containsKey(id)) throw new OrderNotFoundException("Order with Isbn " + id );
        Order order = orderRepository.getOrder(id);
        updateStocksDueToOrdering(order);
        order.setOrderStatus(OrderStatus.ORDERED);
        return orderMapper.detailDTO(order);
    }

    public OrderDTO reorderOldOrder(String oldOrderId) {
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
                    Item item = itemRepository.getItem(itemGroup.getItemId());
                    int amountInStock = item.getAmount();
                    int newStockAfterOrderPlacement = amountInStock - orderedAmount;
                    item.setAmount(newStockAfterOrderPlacement);
        });

    }

    public OrderOverviewDTO makeAnOrderSummaryForACustomer(String customerId){
        return new OrderOverviewDTO(getAllMyOrderDTOs(customerId));
    }

    public Order cloneOrderWhichHasAdaptedPricesForItemGroups(String orderId){
        Order oldOrder = orderRepository.getOrderMap().get(orderId);
        Order newOrder = new Order(oldOrder);
        newOrder.getItemGroups()
                .forEach(itemGroup -> itemGroup.setOrderPrice(itemRepository.getItem(itemGroup.getItemId()).getPrice()));
        return newOrder;
    }


}
