package com.switchfully.oerder.demo.service.mappers;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.business.repositories.ItemCrudRepository;
import com.switchfully.oerder.demo.business.repositories.OrderCrudRepository;
import com.switchfully.oerder.demo.service.dtos.items.ItemGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ItemGroupMapper {

    private final ItemCrudRepository itemCrudRepository;
    private final OrderCrudRepository orderCrudRepository;

    @Autowired
    public ItemGroupMapper(
            ItemCrudRepository itemCrudRepository,
            OrderCrudRepository orderCrudRepository
    ){
        this.itemCrudRepository = itemCrudRepository;
        this.orderCrudRepository = orderCrudRepository;
    }

    public ItemGroup createItemGroup(ItemGroupDTO itemGroupDTO, LocalDate shippingDate) {
        Item item = itemCrudRepository.findById(itemGroupDTO.getItemId()).get();
        Order order = orderCrudRepository.findById(itemGroupDTO.getOrderId()).get();
        ItemGroup result = new ItemGroup(
                order,
                item,
                itemGroupDTO.getAmount(),
                itemGroupDTO.getOrderPrice(),
                shippingDate
        );
        return result;
    }

    public ItemGroupDTO detailDTO(ItemGroup itemGroup) {
        ItemGroupDTO result = new ItemGroupDTO();
        result.setOrderId(itemGroup.getOrder().getOrderId());
        result.setItemId(itemGroup.getItem().getItemId());
        result.setAmount(itemGroup.getAmount());
        result.setOrderPrice(itemGroup.getOrderPrice());
        result.setShippingDate(itemGroup.getShippingDate());
        return result;
    }
}
