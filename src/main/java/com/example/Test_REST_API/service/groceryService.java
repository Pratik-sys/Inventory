package com.example.Test_REST_API.service;

import com.example.Test_REST_API.model.GroceryItem;
import com.example.Test_REST_API.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
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
        Optional<GroceryItem> itemDB = groceryRepo.findById(id);
        if(itemDB.isPresent()){
            GroceryItem _itemUpdateDB = itemDB.get();
            System.out.println(itemDB.get().getCategory());
            _itemUpdateDB.setName(groceryItem.getName());
            _itemUpdateDB.setQuantity((groceryItem.getQuantity()));
            _itemUpdateDB.setCategory((groceryItem.getCategory()));
            _itemUpdateDB.setPrice(groceryItem.getPrice());
            _itemUpdateDB.setStockAvailability(groceryItem.isStockAvailability());
            groceryRepo.save(_itemUpdateDB);
            return _itemUpdateDB;
        }
        else {
            throw new Exception("Record not found with id : " + id);
            }
        }
        public ResponseEntity<String> deleteItem(String id) throws Exception {
            Optional<GroceryItem> itemDB = groceryRepo.findById(id);
            if (itemDB.isPresent()){
                groceryRepo.deleteById(id);
                return  ResponseEntity.ok().body("Item deleted with id " + id);
            }
            else{throw  new Exception();}
        }
        public  List<GroceryItem> finByCategory(String category){
            return  groceryRepo.findByCategory(category);

        }
        public  List<GroceryItem> findByAvalibility(boolean stockAvailability){

            return groceryRepo.findBystockAvailability(stockAvailability);
        }

    }

