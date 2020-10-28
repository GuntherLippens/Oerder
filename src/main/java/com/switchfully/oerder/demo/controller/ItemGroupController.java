package com.switchfully.oerder.demo.controller;

import com.switchfully.oerder.demo.service.dtos.items.ItemGroupDTO;
import com.switchfully.oerder.demo.service.services.ItemGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/itemgroups")
public class ItemGroupController {
    private final ItemGroupService itemGroupService;

    @Autowired
    public ItemGroupController(ItemGroupService itemGroupService) {
        this.itemGroupService = itemGroupService;
    }

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemGroupDTO> getAllItemGroups() {
        return itemGroupService.getAllItemGroupDTOs();
    }

    @PostMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemGroupDTO save(@RequestBody ItemGroupDTO itemGroupDTO) {
        return itemGroupService.registerItemGroup(itemGroupDTO);
    }

    @PutMapping(path = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemGroupDTO update(@PathVariable String id, @RequestBody ItemGroupDTO itemGroupDTO) {
        return itemGroupService.updateItemGroup(id, itemGroupDTO);
    }
}
