package com.switchfully.oerder.demo.controller;

import com.switchfully.oerder.demo.service.dtos.items.OrderDTO;
import com.switchfully.oerder.demo.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> adminViewsAllOrders() {
        return orderService.getAllOrderDTOs();
    }

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> customerViewsAllHisOrders(@PathVariable String customerId) {
        return orderService.getAllMyOrderDTOs(customerId);
    }

    @PostMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createNewEmptyOrderWithStatusCreated(@RequestBody OrderDTO orderDTO) {
        return orderService.registerOrder(orderDTO);
    }

    @PutMapping(path = "/customer/place-order/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO updateOrderStatusFromCreatedToOrdered(@PathVariable String id) {
        return orderService.placeOrder(id);
    }
}
