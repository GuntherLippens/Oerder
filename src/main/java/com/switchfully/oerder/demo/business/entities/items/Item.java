package com.switchfully.oerder.demo.business.entities.items;

import com.switchfully.oerder.demo.business.entities.Entity;

import java.util.Objects;
import java.util.UUID;

public class Item implements Entity {
    private String name;
    private String decription;
    private double price;
    private int amount;
    private String itemId;

    public Item(String name, String decription, double price, int amount) {
        this.name = name;
        this.decription = decription;
        this.price = price;
        this.amount = amount;
        this.itemId = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getItemId().equals(item.getItemId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId());
    }
}
