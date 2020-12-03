package com.switchfully.oerder.demo.controller;

import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.service.dtos.items.OrderDTO;
import com.switchfully.oerder.demo.service.dtos.items.OrderOverviewDTO;
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
    public List<OrderDTO> viewAllOrders_AsAnAdmin() {
        return orderService.getAllOrderDTOs();
    }

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public OrderOverviewDTO viewsAllYourOrders_AsACustomer(@PathVariable int customerId) {
        return orderService.makeAnOrderSummaryForACustomer(customerId);
    }

    @PostMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createNewOrderWithEmptyItemGroupList_AndWithStatusCreated_AsACustomer(@RequestBody OrderDTO orderDTO) {
        return orderService.registerOrder(orderDTO);
    }

    @PutMapping(path = "/customer/place-order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO updateOrderStatus_FromCreatedToOrdered(@PathVariable Order orderId) {
        return orderService.placeOrder(orderId);
    }

    @PostMapping(path = "/customer/re-order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO reorderAnOldAlreadyRegisteredOrderAgain_AsACustomer(@PathVariable int orderId) {
        return orderService.reorderOldOrder(orderId);
    }

}
