package com.example.Test_REST_API.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class GroceryItem {
    @Id
    private ObjectId id;
    private String name;
    private  String quantity;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private  String category;

    public GroceryItem(String name, String quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }
    public GroceryItem(ObjectId id, String name, String quantity, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

}
