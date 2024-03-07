package com.example.Test_REST_API.service;

import com.example.Test_REST_API.model.GroceryItem;
import com.example.Test_REST_API.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public GroceryItem updateItem(String id, GroceryItem groceryItem) throws Exception {
        Optional<GroceryItem> groceryItemdb = groceryRepo.findById(id);
        if(groceryItemdb.isPresent()){
            GroceryItem _updateitem = groceryItemdb.get();
            _updateitem.setName(groceryItem.getName());
            _updateitem.setQuantity((groceryItem.getQuantity()));
            _updateitem.setCategory((groceryItem.getCategory()));
            groceryRepo.save(_updateitem);
            return _updateitem;
        }
        else {
            throw new Exception("Record not found with id : " + id);
            }
        }


    }

