package com.example.Inventory.controller;
import com.example.Inventory.model.Product;
import com.example.Inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/items")
    public ResponseEntity<List<Product>> getAllItems(){
        return  ResponseEntity.ok().body(productService.getAllGroceries());
    }
    @PostMapping("/add-items")
    public  ResponseEntity<Product> addItems(@RequestBody Product Product){
        return ResponseEntity.ok().body(productService.addItems(Product));
    }
    @PutMapping("/item-update/{id}")
    public ResponseEntity<Product> updateItems(@PathVariable("id") String id, @RequestBody Product Product) throws Exception {
        return ResponseEntity.ok().body(productService.updateItem(id, Product));
    }
    @DeleteMapping("/item-delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") String id) {
        productService.deleteItem(id);
        return ResponseEntity.ok().body("User successfully deleted!");
    }
    @GetMapping("/find-category/{category}")
    public  ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category){
        return  ResponseEntity.ok().body(productService.finByCategory(category));
    }
    @GetMapping("/stocks")
    public  ResponseEntity<List<Product>> getByAvailability(@RequestParam("stockAvailability") boolean stockAvailability){
        return  ResponseEntity.ok().body(productService.findByAvailability(stockAvailability));
    }

}
