package com.switchfully.oerder.demo.controller;

import com.switchfully.oerder.demo.service.dtos.items.ItemDTO;
import com.switchfully.oerder.demo.service.dtos.items.ItemStockStatusDTO;
import com.switchfully.oerder.demo.service.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDTO> getAllItems_AsAnAdmin() {
        return itemService.getAllItemDTOs();
    }

    @PostMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addANewItem_AsAnAdmin(@RequestBody ItemDTO itemDTO) {
        return itemService.registerItem(itemDTO);
    }

    @PutMapping(path = "/admin/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO updateAnExitingItem_AsAnAdmin(@PathVariable int id, @RequestBody ItemDTO itemDTO) {
        return itemService.updateItem(id, itemDTO);
    }

    @GetMapping(path = "/admin/stock-status", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemStockStatusDTO> getStockStatusOfAllItems_AsAnAdmin() {
        return itemService.getAllItemStockStatusDTOs();
    }
}
