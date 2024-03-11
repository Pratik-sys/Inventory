package com.example.Test_REST_API.controller;
import com.example.Test_REST_API.model.productItem;
import com.example.Test_REST_API.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class productController {

    @Autowired
    private productService productService;

    @GetMapping("/items")
    public ResponseEntity<List<productItem>> getAllItems(){
        return  ResponseEntity.ok().body(productService.getAllGroceries());
    }
    @PostMapping("/add-items")
    public  ResponseEntity<productItem> addItems(@RequestBody productItem productItem){
        return ResponseEntity.ok().body(productService.addItems(productItem));
    }
    @PutMapping("/item-update/{id}")
    public ResponseEntity<productItem> updateItems(@PathVariable("id") String id, @RequestBody productItem productItem) throws Exception {
        return ResponseEntity.ok().body(productService.updateItem(id, productItem));
    }
    @DeleteMapping("/item-delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok().body(productService.deleteItem(id));
    }
    @GetMapping("/find-category/{category}")
    public  ResponseEntity<List<productItem>> getByCategory(@PathVariable("category") String category){
        return  ResponseEntity.ok().body(productService.finByCategory(category));
    }
    @GetMapping("/stocks")
    public  ResponseEntity<List<productItem>> getByAvailability(@RequestParam("stockAvailability") boolean stockAvailability){
        return  ResponseEntity.ok().body(productService.findByAvailability(stockAvailability));
    }

}
