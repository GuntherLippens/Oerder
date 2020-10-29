package com.switchfully.oerder.demo.service.mappers;

import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.service.dtos.items.ItemGroupDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ItemGroupMapper {
    public ItemGroup createItemGroup(ItemGroupDTO itemGroupDTO, LocalDate shippingDate) {
        ItemGroup result = new ItemGroup(
                itemGroupDTO.getOrderGroupId(),
                itemGroupDTO.getItemId(),
                itemGroupDTO.getAmount(),
                itemGroupDTO.getOrderPrice(),
                shippingDate
        );
        return result;
    }

    public ItemGroupDTO detailDTO(ItemGroup itemGroup) {
        ItemGroupDTO result = new ItemGroupDTO();
        result.setOrderGroupId(itemGroup.getOrderGroupId());
        result.setItemGroupId(itemGroup.getOrderGroupId());
        result.setItemId(itemGroup.getItemId());
        result.setAmount(itemGroup.getAmount());
        result.setOrderPrice(itemGroup.getOrderPrice());
        result.setShippingDate(itemGroup.getShippingDate());
        result.setItemGroupId(itemGroup.getItemGroupId());
        return result;
    }
}
