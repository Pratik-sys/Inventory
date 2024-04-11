package com.example.Inventory.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductAddDTO {
    private String id;
    private String name;
    private int quantity;
    private String category;
    private double price;
    private boolean stockAvailability;
    private Date createdTime = new Date();
}
