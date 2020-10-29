package com.switchfully.oerder.demo.business.repositories;


import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.exceptions.ItemGroupAlreadyExistsException;
import com.switchfully.oerder.demo.exceptions.ItemGroupNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class ItemGroupRepository {

    private final Map<String, ItemGroup> itemGroups;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemGroupRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.itemGroups = new HashMap<>();
        addFirstItemGroup();
    }

    public ItemGroup save(ItemGroup itemGroup) {
        if (itemGroups.containsValue(itemGroup))
            throw new ItemGroupAlreadyExistsException(
                    "ItemGroup with id"
                            + itemGroup.getItemGroupId()
                            + " already exists.");
        itemGroups.put(itemGroup.getItemGroupId(), itemGroup);

        return itemGroup;
    }

    public ItemGroup getItemGroup(String itemGroupId) {
        ItemGroup item = itemGroups.get(itemGroupId);
        if (Objects.isNull(item)) {
            throw new ItemGroupNotFoundException("There is no itemGroup available with the id " + itemGroupId);
        }
        return item;
    }

    public Map<String, ItemGroup> getItemGroupMap() {
        return itemGroups;
    }

    public void addFirstItemGroup() {
        ItemGroup itemGroup = new ItemGroup(
                 "007default-item-group-id-points-to-nowhere-be-careful!",
                 itemRepository.getFirstDefaultItem().getId(),
                10,
                6.66,
                 LocalDate.now().plusYears(1000));

        itemGroups.put(itemGroup.getItemGroupId(), itemGroup);
    }

    public List<ItemGroup> getItemGroups() {
        return new ArrayList<>(itemGroups.values());
    }


}
