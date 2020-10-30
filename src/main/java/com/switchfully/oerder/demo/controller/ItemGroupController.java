package com.switchfully.oerder.demo.controller;

import com.switchfully.oerder.demo.service.dtos.items.ItemGroupDTO;
import com.switchfully.oerder.demo.service.services.ItemGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/shopping-cart")
public class ItemGroupController {
    private final ItemGroupService itemGroupService;

    @Autowired
    public ItemGroupController(ItemGroupService itemGroupService) {
        this.itemGroupService = itemGroupService;
    }

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemGroupDTO> getAllItemGroupsCurrentlyInYourShoppingCart_AsACustomer() {
        return itemGroupService.getAllItemGroupDTOs();
    }

    @PostMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemGroupDTO addANewItemGroupToYourShoppingCart_AsACustomer_WillBeAddedToItemGroupListInRelatedOrder(@RequestBody ItemGroupDTO itemGroupDTO) {
        return itemGroupService.registerItemGroup(itemGroupDTO);
    }

}
