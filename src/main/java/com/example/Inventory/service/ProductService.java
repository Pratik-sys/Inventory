package com.example.Inventory.service;
import com.example.Inventory.dto.ProductAddDTO;
import com.example.Inventory.dto.ProductUpdateDTO;
import com.example.Inventory.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllGroceries();
    ProductAddDTO addProducts(ProductAddDTO productAddDTO);
    List<Product> finByCategory(String category);
    List<Product> findByAvailability(boolean stockAvailability);
    ProductUpdateDTO updateProductById(String id, ProductUpdateDTO productUpdateDTO);
    void deleteItem(String id);

}

