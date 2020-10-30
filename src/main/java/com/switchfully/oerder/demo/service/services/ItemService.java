package com.switchfully.oerder.demo.service.services;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.business.repositories.ItemRepository;
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

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemDTO> getAllItemDTOs() {
        return itemRepository.getItems().stream()
                .map(item -> itemMapper.detailDTO(item))
                .collect(Collectors.toList());
    }

    public List<ItemStockStatusDTO> getAllItemStockStatusDTOs() {
        List<ItemStockStatusDTO> itemStockStatusDTOList=  itemRepository
                .getItems()
                .stream()
                .map(item -> itemMapper.stockStatusDTO((item)))
                .collect(Collectors.toList());
        Collections.sort(itemStockStatusDTOList);
        return itemStockStatusDTOList;
    }

    public ItemDTO getItemDetailsById(String id) {
        return itemMapper.detailDTO(itemRepository.getItem(id));

    }

    public ItemDTO registerItem(ItemDTO itemDTO) {
        Item item = itemRepository.save(itemMapper.createItem(itemDTO));
        return itemMapper.detailDTO(item);
    }

    public ItemDTO updateItem(String id, ItemDTO itemDTO) {
        if (!itemRepository.getItemMap().containsKey(id)) throw new ItemNotFoundException("Item with Isbn " + id );

        Item item = itemRepository.getItem(id);
        item.setName(itemDTO.getName());
        item.setDecription(itemDTO.getDescription());
        item.setAmount(itemDTO.getAmount());
        item.setPrice(itemDTO.getPrice());
        return itemMapper.detailDTO(item);
    }



}
