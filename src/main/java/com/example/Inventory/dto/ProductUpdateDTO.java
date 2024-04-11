package com.example.Inventory.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductUpdateDTO {
    private String name;
    private int quantity;
    private String category;
    private double price;
    private boolean stockAvailability;
}
