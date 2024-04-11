package com.example.Inventory.service;
import com.example.Inventory.dto.ProductAddDTO;
import com.example.Inventory.dto.ProductUpdateDTO;
import com.example.Inventory.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    ProductAddDTO addProducts(ProductAddDTO productAddDTO);
    List<Product> findProductByCategory(String category);
    List<Product> findProductByAvailability(boolean stockAvailability);
    ProductUpdateDTO updateProductById(String id, ProductUpdateDTO productUpdateDTO);
    void deleteProduct(String id);

}

