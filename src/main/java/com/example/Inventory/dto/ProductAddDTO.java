package com.example.Inventory.dto;

import lombok.Data;

@Data
public class ProductAddDTO {
    private String id;
    private String name;
    private int quantity;
    private String category;
    private double price;
    private boolean stockAvailability;
}
