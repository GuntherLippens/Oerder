package com.switchfully.oerder.demo.service.mappers;

import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.service.dtos.items.OrderDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OrderMapper {
    public Order createOrder(OrderDTO orderDTO) {
        Order result = new Order(
                orderDTO.getCustomerId()
        );
        return result;
    }

    public OrderDTO detailDTO(Order order) {
        OrderDTO result = new OrderDTO();
        result.setOrderId(order.getOrderId());
        result.setCustomerId(order.getCustomerId());
        result.setItemGroups(order.getItemGroups());
        result.setOrderStatus(order.getOrderStatus());
        result.setTotalPrice(order.getTotalPrice());
        return result;
    }


}
