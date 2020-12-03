package com.switchfully.oerder.demo.business.repositories;


import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import com.switchfully.oerder.demo.business.entities.items.Order;
import com.switchfully.oerder.demo.exceptions.items.ItemGroupAlreadyExistsException;
import com.switchfully.oerder.demo.exceptions.items.ItemGroupNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class ItemGroupRepository {

    private final Map<Integer, ItemGroup> itemGroups;
    private final ItemCrudRepository itemRepository;

    @Autowired
    public ItemGroupRepository(ItemCrudRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.itemGroups = new HashMap<Integer, ItemGroup>();
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

    public Map<Integer, ItemGroup> getItemGroupMap() {
        return itemGroups;
    }

    public void addFirstItemGroup() {

    }

    public List<ItemGroup> getItemGroups() {
        return new ArrayList<>(itemGroups.values());
    }


}
