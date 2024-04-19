package com.example.Inventory.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Inventory.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>  {}