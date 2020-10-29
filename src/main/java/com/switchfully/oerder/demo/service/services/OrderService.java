package com.switchfully.oerder.demo.service.services;

import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.business.entities.items.OrderStatus;
import com.switchfully.oerder.demo.business.repositories.OrderRepository;
import com.switchfully.oerder.demo.exceptions.OrderNotFoundException;
import com.switchfully.oerder.demo.service.dtos.items.OrderDTO;
import com.switchfully.oerder.demo.service.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> getAllOrderDTOs() {
        return orderRepository.getOrders().stream()
                .map(orderMapper::detailDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO getOrderDetailsById(String id) {
        return orderMapper.detailDTO(orderRepository.getOrder(id));

    }

    public OrderDTO registerOrder(OrderDTO orderDTO) {
        Order order = orderRepository.save(orderMapper.createOrder(orderDTO));
        return orderMapper.detailDTO(order);
    }

    public OrderDTO placeOrder(String id, OrderDTO orderDTO) {
        if (!orderRepository.getOrderMap().containsKey(id)) throw new OrderNotFoundException("Order with Isbn " + id );
        Order order = orderRepository.getOrder(id);
        order.setOrderStatus(OrderStatus.ORDERED);
        return orderMapper.detailDTO(order);
    }


}
