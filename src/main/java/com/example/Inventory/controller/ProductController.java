package com.example.Inventory.controller;
import com.example.Inventory.dto.ProductAddDTO;
import com.example.Inventory.dto.ProductUpdateDTO;
import com.example.Inventory.model.Product;
import com.example.Inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/listAll")
    public ResponseEntity<List<Product>> getAllItems(){
        return  ResponseEntity.ok().body(productService.getAllProducts());
    }
    @PostMapping("/add")
    public  ResponseEntity<ProductAddDTO> addItems(@RequestBody ProductAddDTO productAddDTO){
        return ResponseEntity.ok().body(productService.addProducts(productAddDTO));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductUpdateDTO> updateItems(@PathVariable("id") String id, @RequestBody ProductUpdateDTO productUpdateDTO){
        return ResponseEntity.ok().body(productService.updateProductById(id, productUpdateDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("User successfully deleted!");
    }
    @GetMapping("/find-category/{category}")
    public  ResponseEntity<List<Product>> getByCategory(@PathVariable("category") String category){
        return  ResponseEntity.ok().body(productService.findProductByCategory(category));
    }
    @GetMapping("/stock")
    public  ResponseEntity<List<Product>> getByAvailability(@RequestParam("stockAvailability") boolean stockAvailability){
        return  ResponseEntity.ok().body(productService.findProductByAvailability(stockAvailability));
    }

}
