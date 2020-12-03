package com.switchfully.oerder.demo.service.services;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.business.repositories.ItemCrudRepository;
import com.switchfully.oerder.demo.exceptions.items.ItemNotFoundException;
import com.switchfully.oerder.demo.service.dtos.items.ItemDTO;
import com.switchfully.oerder.demo.service.dtos.items.ItemStockStatusDTO;
import com.switchfully.oerder.demo.service.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemCrudRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemCrudRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemDTO> getAllItemDTOs() {
        return ((List<Item>)itemRepository.findAll()).stream()
                .map(itemMapper::detailDTO)
                .collect(Collectors.toList());
    }

    public List<ItemStockStatusDTO> getAllItemStockStatusDTOs() {
        List<ItemStockStatusDTO> itemStockStatusDTOList=
                ((List<Item>) itemRepository.findAll())
                .stream()
                .map(itemMapper::stockStatusDTO)
                .collect(Collectors.toList());
        Collections.sort(itemStockStatusDTOList);
        return itemStockStatusDTOList;
    }

    public ItemDTO getItemDetailsById(int id) {
        if (itemRepository.findById(id).isEmpty()) {
            throw new ItemNotFoundException("No item found with id = " + id);
        }
        return itemMapper.detailDTO(itemRepository.findById(id).get());

    }

    public ItemDTO registerItem(ItemDTO itemDTO) {
        Item item = itemRepository.save(itemMapper.createItem(itemDTO));
        return itemMapper.detailDTO(item);
    }

    public ItemDTO updateItem(int id, ItemDTO itemDTO) {
        if (itemRepository.findById(id).isEmpty()) {
            throw new ItemNotFoundException("No item found with id = " + id);
        }
        Item item = itemRepository.findById(id).get();
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setAmount(itemDTO.getAmount());
        item.setPrice(itemDTO.getPrice());
        itemRepository.save(item);
        return itemMapper.detailDTO(item);
    }



}
