package com.example.Inventory.service;

import com.example.Inventory.model.Product;
import com.example.Inventory.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepo;

    @Override
    public List<Product> getAllGroceries() {
        return productRepo.findAll();
    }
    @Override
    public List<Product> finByCategory(String category) {
        return  productRepo.findByCategory(category);
    }
    @Override
    public List<Product> findByAvailability(boolean stockAvailability) {
        return productRepo.findByStockAvailability(stockAvailability);
    }
    @Override
    public Product addItems(Product Product) {
        return productRepo.save(Product);
    }

    @Override
    public Product updateItem(String id, Product Product) {
        return null;
    }

    @Override
    public void deleteItem(String id) {
        productRepo.deleteById(id);
    }
}
