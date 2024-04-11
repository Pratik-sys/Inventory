package com.example.Inventory.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document
public class Product {
    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;
    private double price;
    private boolean stockAvailability;
    private Date createdTime = new Date();
    private  Date lastUpdateTime = new Date();


}
