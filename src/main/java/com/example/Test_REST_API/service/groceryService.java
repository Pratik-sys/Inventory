package com.example.Test_REST_API.service;

import com.example.Test_REST_API.model.GroceryItem;
import com.example.Test_REST_API.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class groceryService {
    @Autowired
    private ItemRepository groceryRepo;

    public List<GroceryItem> getAllGroceries(){
        return groceryRepo.findAll();
    }
    public  GroceryItem addItems(GroceryItem groceryItem){
        return groceryRepo.save(groceryItem);
    }
}
