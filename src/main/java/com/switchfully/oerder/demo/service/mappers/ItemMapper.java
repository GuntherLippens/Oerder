package com.switchfully.oerder.demo.service.mappers;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.service.dtos.items.ItemDTO;
import com.switchfully.oerder.demo.service.dtos.items.ItemStockStatusDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item createItem(ItemDTO itemDTO) {
        return new Item(
                itemDTO.getName(),
                itemDTO.getDescription(),
                itemDTO.getPrice(),
                itemDTO.getAmount());
    }

    public ItemDTO detailDTO(Item item) {
        ItemDTO result = new ItemDTO();
        result.setName(item.getName());
        result.setDescription(item.getDescription());
        result.setPrice(item.getAmount());
        result.setAmount(item.getAmount());
        return result;
    }

    public ItemStockStatusDTO stockStatusDTO(Item item){
        ItemStockStatusDTO result = new ItemStockStatusDTO();
        result.setItemId(item.getItemId());
        result.setName(item.getName());
        result.setDescription(item.getDescription());
        result.setPrice(item.getAmount());
        result.setStockStatus(ItemStockStatusDTO.calculateStockStatus(item.getAmount()));
        return result;
    }


    
}
