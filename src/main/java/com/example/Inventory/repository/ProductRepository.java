package com.example.Inventory.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Inventory.model.Product;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String>  {
    @Query("{'category' : ?0}")
    List<Product> findByCategory(String category);

    @Query("{'stockAvailability' : ?0}")
    List<Product> findByStockAvailability(boolean stockAvailability);
}