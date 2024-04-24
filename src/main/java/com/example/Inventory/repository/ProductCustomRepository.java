package com.example.Inventory.repository;

import com.example.Inventory.model.Product;

import java.util.List;

public interface ProductCustomRepository {

    List<Product> findByCategory(String category);
    List<Product> findStockByAvailability(boolean stockAvailability);
}
