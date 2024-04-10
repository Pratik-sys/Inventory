package com.example.Inventory.service;
import com.example.Inventory.model.Product;
import com.example.Inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllGroceries();
    Product addItems(Product Product);
    List<Product> finByCategory(String category);
    List<Product> findByAvailability(boolean stockAvailability);
    Product updateItem(String id, Product Product);
    void deleteItem(String id);

}

