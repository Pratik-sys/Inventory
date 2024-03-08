package com.example.Test_REST_API.model;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

public class GroceryItem {
    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;
    private double price;
    private boolean StockAvailability;
    private  LocalDateTime createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStockAvailability() {
        return StockAvailability;
    }

    public void setStockAvailability(boolean stockAvailability) {
        StockAvailability = stockAvailability;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public GroceryItem(String name, int quantity, String category, double price, boolean stockAvailability, LocalDateTime createdTime) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
        this.price = price;
        StockAvailability = stockAvailability;
        this.createdTime = createdTime;
    }
}
