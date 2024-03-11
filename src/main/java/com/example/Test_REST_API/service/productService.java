package com.example.Test_REST_API.service;
import com.example.Test_REST_API.model.productItem;
import com.example.Test_REST_API.repository.productItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class productService {
    @Autowired
    private productItemRepository productRepo;

    public List<productItem> getAllGroceries(){
        return productRepo.findAll();
    }
    public productItem addItems(productItem productItem){
        return productRepo.save(productItem);
    }
    public  List<productItem> finByCategory(String category){return  productRepo.findByCategory(category);}
    public  List<productItem> findByAvailability(boolean stockAvailability){return productRepo.findByStockAvailability(stockAvailability);}
    public productItem updateItem(String id, productItem productItem) throws Exception {
        Optional<productItem> itemDB = productRepo.findById(id);
        if(itemDB.isPresent()){
            productItem _itemUpdateDB = itemDB.get();
            _itemUpdateDB.setName(productItem.getName());
            _itemUpdateDB.setQuantity((productItem.getQuantity()));
            _itemUpdateDB.setCategory((productItem.getCategory()));
            _itemUpdateDB.setPrice(productItem.getPrice());
            _itemUpdateDB.setStockAvailability(productItem.isStockAvailability());
            productRepo.save(_itemUpdateDB);
            return _itemUpdateDB;
        }
        else {
            throw new Exception("Record not found with id : " + id);
            }
        }
        public String deleteItem(String id) throws Exception {
            Optional<productItem> itemDB = productRepo.findById(id);
            if (itemDB.isPresent()){
                productRepo.deleteById(id);
                return ("Item deleted with id " + id);
            }
            else{throw  new Exception();}
        }


    }

