package com.example.Test_REST_API.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.Test_REST_API.models.GroceryItem;
import org.springframework.stereotype.Repository;

public interface ItemRepository extends MongoRepository<GroceryItem, Long>  {
    public long count();
}