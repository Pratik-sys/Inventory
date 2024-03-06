package com.example.Test_REST_API.controller;

import com.example.Test_REST_API.model.GroceryItem;
import com.example.Test_REST_API.service.groceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class groceryController {

    @Autowired
    private groceryService gs;

@GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getAllItems(){
        return  ResponseEntity.ok().body(gs.getAllGroceries());
    }

}
