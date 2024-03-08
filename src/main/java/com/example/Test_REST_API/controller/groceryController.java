package com.example.Test_REST_API.controller;

import com.example.Test_REST_API.model.GroceryItem;
import com.example.Test_REST_API.service.groceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class groceryController {

    @Autowired
    private groceryService gs;

@GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getAllItems(){
        return  ResponseEntity.ok().body(gs.getAllGroceries());
    }
    @PostMapping("/add-items")
    public  ResponseEntity<GroceryItem> addItems(@RequestBody GroceryItem groceryItem){
        return ResponseEntity.ok().body(gs.addItems(groceryItem));
    }

    @PutMapping("/item-update/{id}")
    public ResponseEntity<GroceryItem> updateItems(@PathVariable("id") String id, @RequestBody GroceryItem groceryItem) throws Exception {
        return ResponseEntity.ok().body(gs.updateItem(id, groceryItem));
    }
    @DeleteMapping("/item-delete/{id}")
    public ResponseEntity deleteItem(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok().body(gs.deleteItem(id));
    }
    @GetMapping("/find-category/{category}")
    public  ResponseEntity<List<GroceryItem>> getByCategory(@PathVariable("category") String category){
        return  ResponseEntity.ok().body(gs.finByCategory(category));
    }

}
