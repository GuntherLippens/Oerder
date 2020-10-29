package com.switchfully.oerder.demo.service.services;


import com.switchfully.oerder.demo.business.entities.items.Item;
import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.business.repositories.ItemGroupRepository;
import com.switchfully.oerder.demo.business.repositories.ItemRepository;
import com.switchfully.oerder.demo.business.repositories.OrderRepository;
import com.switchfully.oerder.demo.exceptions.items.ItemGroupNotFoundException;

import com.switchfully.oerder.demo.service.dtos.items.ItemGroupDTO;
import com.switchfully.oerder.demo.service.mappers.ItemGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemGroupService {

    private final ItemGroupRepository itemGroupRepository;
    private final ItemRepository itemRepository;
    private final ItemGroupMapper itemGroupMapper;
    private final OrderRepository orderRepository;

    @Autowired
    public ItemGroupService(
            ItemGroupRepository itemGroupRepository,
            ItemRepository itemRepository,
            ItemGroupMapper itemGroupMapper,
            OrderRepository orderRepository) {
        this.itemGroupRepository = itemGroupRepository;
        this.itemRepository = itemRepository;
        this.itemGroupMapper = itemGroupMapper;
        this.orderRepository = orderRepository;
    }

    public List<ItemGroupDTO> getAllItemGroupDTOs() {
        return itemGroupRepository.getItemGroups().stream()
                .map(itemGroupMapper::detailDTO)
                .collect(Collectors.toList());
    }

    public ItemGroupDTO getItemGroupDetailsById(String id) {
        return itemGroupMapper.detailDTO(itemGroupRepository.getItemGroup(id));

    }

    public ItemGroupDTO registerItemGroup(ItemGroupDTO itemGroupDTO) {
        ItemGroup itemGroup = itemGroupRepository.save(itemGroupMapper.createItemGroup(itemGroupDTO,calculateShippingDate(itemGroupDTO)));
        itemGroup.setOrderPrice(itemRepository.getItem(itemGroupDTO.getItemId()).getPrice());
        Order currentOrder = orderRepository.getOrder(itemGroupDTO.getOrderId());
        currentOrder.addItemGroup(itemGroup);
        return itemGroupMapper.detailDTO(itemGroup);
    }

    public ItemGroupDTO updateItemGroup(String id, ItemGroupDTO itemGroupDTO) {
        if (!itemGroupRepository.getItemGroupMap().containsKey(id)) throw new ItemGroupNotFoundException("ItemGroup with Isbn " + id );
        ItemGroup itemGroup = itemGroupRepository.getItemGroup(id);
        itemGroup.setAmount(itemGroupDTO.getAmount());
        itemGroup.setOrderPrice(itemGroupDTO.getOrderPrice());
        itemGroup.setShippingDate(calculateShippingDate(itemGroupDTO));
        return itemGroupMapper.detailDTO(itemGroup);
    }

    private LocalDate calculateShippingDate(ItemGroupDTO itemGroupDTO){
        LocalDate shippingDate;
        int amountOrdered = itemGroupDTO.getAmount();
        String itemGroupId = itemGroupDTO.getItemId();
        Item item = itemRepository.getItem(itemGroupId);
        int amountLeft = item.getAmount();
        if (amountLeft - amountOrdered > 0){
            shippingDate = LocalDate.now().plusDays(1);
        } else {
            shippingDate = LocalDate.now().plusDays(7);
        }
        return shippingDate;
    }
}
