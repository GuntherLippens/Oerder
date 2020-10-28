package com.switchfully.oerder.demo.business.entities.items;

import com.switchfully.oerder.demo.business.entities.Entity;

import java.util.UUID;

public class Item implements Entity {
    private String name;
    private String decription;
    private double price;
    private int amount;
    private String id;

    public Item(String name, String decription, double price, int amount) {
        this.name = name;
        this.decription = decription;
        this.price = price;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
