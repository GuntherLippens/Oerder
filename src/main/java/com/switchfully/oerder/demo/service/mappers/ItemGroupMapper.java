package com.switchfully.oerder.demo.service.mappers;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.service.dtos.items.ItemDTO;
import com.switchfully.oerder.demo.service.dtos.items.ItemGroupDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ItemGroupMapper {
    public ItemGroup createItemGroup(ItemGroupDTO itemGroupDTO, LocalDate shippingDate) {
        return new ItemGroup(
                itemGroupDTO.getId(),
                itemGroupDTO.getAmount(),
                itemGroupDTO.getOrderPrice(),
                shippingDate
        );

    }

    public ItemGroupDTO detailDTO(ItemGroup itemGroup) {
        ItemGroupDTO result = new ItemGroupDTO();
        result.setId(itemGroup.getId());
        result.setAmount(itemGroup.getAmount());
        result.setOrderPrice(itemGroup.getOrderPrice());
        return result;
    }
}
