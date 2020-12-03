package com.switchfully.oerder.demo.service.dtos.items;

import com.switchfully.oerder.demo.utilities.StockStatus;

public class ItemStockStatusDTO implements Comparable{
    private String name;
    private String description;
    private double price;
    private StockStatus stockStatus;
    private int itemId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public static StockStatus calculateStockStatus (double amount) {
        if (amount < 5) {
            return StockStatus.STOCK_LOW;
        } else if (amount < 10) {
            return StockStatus.STOCK_MEDIUM;
        } else {
            return StockStatus.STOCK_HIGH;
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0; // nog te implementeren via parameter in de StockStatus enum;
    }
}
