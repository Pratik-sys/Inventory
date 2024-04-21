package com.example.Inventory.repository;

import com.example.Inventory.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductCustomRepositoryImpl implements ProductCustomRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Product> findByCategory(String category) {
        Criteria criteria = Criteria.where("category").is(category);
        Query query= new Query(criteria);
        return mongoTemplate.find(query,Product.class);
    }

    @Override
    public List<Product> findStockByAvailability(boolean stockAvailability) {
        Criteria criteria = Criteria.where("stockAvailability").is(stockAvailability);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Product.class);
    }
}
