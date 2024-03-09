package com.example.Test_REST_API.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Test_REST_API.model.GroceryItem;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<GroceryItem, String>  {
    @Query("{'category' : ?0}")
    List<GroceryItem> findByCategory(String category);

    @Query("{'stockAvailability' : ?0}")
    List<GroceryItem> findBystockAvailability(boolean stockAvailability);
}