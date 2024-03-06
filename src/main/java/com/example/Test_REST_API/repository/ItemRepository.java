package com.example.Test_REST_API.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Test_REST_API.model.GroceryItem;

public interface ItemRepository extends MongoRepository<GroceryItem, String>  {
}