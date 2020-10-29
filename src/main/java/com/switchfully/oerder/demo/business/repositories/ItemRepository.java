package com.switchfully.oerder.demo.business.repositories;

import com.switchfully.oerder.demo.business.entities.items.Item;

import com.switchfully.oerder.demo.exceptions.items.ItemAlreadyExistsException;
import com.switchfully.oerder.demo.exceptions.items.ItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {

    private final Map<String, Item> items;

    public ItemRepository() {
        this.items = new HashMap<>();
        addFirstItem();
    }

    public Item save(Item item) {
        if (items.containsValue(item))
            throw new ItemAlreadyExistsException(
                            "Item "
                            + item.getDecription()
                            + " already exists.");
        items.put(item.getItemId(), item);

        return item;
    }

    public Item getItem(String id) {
        Item item = items.get(id);
        if (Objects.isNull(item)) {
            throw new ItemNotFoundException("There is no item available with the id " + id);
        }
        return item;
    }

    public Item getFirstDefaultItem () {
        Optional<Item> item = items.values().stream().findFirst();
        return item.orElse(null);
    }

    public Map<String,Item> getItemMap(){
        return items;
    }

    public void addFirstItem(){
        Item item = new Item (
                "Chocolate cookies",
                "Our very first product : Crunchy and yummy high calorie cookies",
                6.66,
                666);
        items.put(item.getItemId(), item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items.values());
    }
}
