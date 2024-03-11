package com.example.Test_REST_API.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Test_REST_API.model.productItem;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface productItemRepository extends MongoRepository<productItem, String>  {
    @Query("{'category' : ?0}")
    List<productItem> findByCategory(String category);

    @Query("{'stockAvailability' : ?0}")
    List<productItem> findByStockAvailability(boolean stockAvailability);
}