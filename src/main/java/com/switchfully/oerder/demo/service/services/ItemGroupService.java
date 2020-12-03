package com.switchfully.oerder.demo.service.services;

import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.business.repositories.*;

import com.switchfully.oerder.demo.service.dtos.items.ItemGroupDTO;
import com.switchfully.oerder.demo.service.mappers.ItemGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemGroupService {

    private final ItemGroupCrudRepository itemGroupRepository;
    private final ItemCrudRepository itemRepository;
    private final ItemGroupMapper itemGroupMapper;
    private final OrderCrudRepository orderRepository;

    @Autowired
    public ItemGroupService(
            ItemGroupCrudRepository itemGroupRepository,
            ItemCrudRepository itemRepository,
            ItemGroupMapper itemGroupMapper,
            OrderCrudRepository orderRepository) {
        this.itemGroupRepository = itemGroupRepository;
        this.itemRepository = itemRepository;
        this.itemGroupMapper = itemGroupMapper;
        this.orderRepository = orderRepository;
    }

    public List<ItemGroupDTO> getAllItemGroupDTOs() {
        return ((List<ItemGroup>)itemGroupRepository.findAll()).stream()
                .map(itemGroupMapper::detailDTO)
                .collect(Collectors.toList());
    }


    public ItemGroupDTO registerItemGroup(ItemGroupDTO itemGroupDTO) {
        ItemGroup itemGroup = itemGroupRepository.save(itemGroupMapper.createItemGroup(itemGroupDTO,calculateShippingDate(itemGroupDTO)));
        return itemGroupMapper.detailDTO(itemGroup);
    }

    private LocalDate calculateShippingDate(ItemGroupDTO itemGroupDTO){
        LocalDate shippingDate;
        int amountOrdered = itemGroupDTO.getAmount();
        int itemGroupId = itemGroupDTO.getItemId();
        Item item = itemRepository.findById(itemGroupId).get();
        int amountLeft = item.getAmount();
        if (amountLeft - amountOrdered > 0){
            shippingDate = LocalDate.now().plusDays(1);
        } else {
            shippingDate = LocalDate.now().plusDays(7);
        }
        return shippingDate;
    }
}
