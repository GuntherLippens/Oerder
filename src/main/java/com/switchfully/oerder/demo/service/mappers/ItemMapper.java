package com.switchfully.oerder.demo.service.mappers;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.service.dtos.items.ItemDTO;
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
        result.setId(item.getId());
        result.setName(item.getName());
        result.setDecription(item.getDecription());
        result.setPrice(item.getAmount());
        result.setAmount(item.getAmount());
        return result;
    }
    
}
