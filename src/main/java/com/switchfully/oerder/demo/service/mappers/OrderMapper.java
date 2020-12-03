package com.switchfully.oerder.demo.service.mappers;

import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.business.entities.users.Customer;
import com.switchfully.oerder.demo.business.repositories.CustomerCrudRepository;
import com.switchfully.oerder.demo.service.dtos.items.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    private final CustomerCrudRepository customerCrudRepository;

    @Autowired
    public OrderMapper(CustomerCrudRepository customerCrudRepository) {
        this.customerCrudRepository = customerCrudRepository;
    }

    public Order createOrder(OrderDTO orderDTO) {
        Customer customer = customerCrudRepository.findById(orderDTO.getCustomerId()).get();
        Order result = new Order(
                customer
        );
        return result;
    }

    public OrderDTO detailDTO(Order order) {
        OrderDTO result = new OrderDTO();
        result.setCustomerId(order.getCustomer().getCustomerId());
        result.setOrderStatus(order.getOrderStatus());
        result.setTotalPrice(order.getTotalPrice());
        return result;
    }


}
