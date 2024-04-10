package com.example.Inventory.service;
import com.example.Inventory.model.Product;
import com.example.Inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllGroceries(){
        return productRepo.findAll();
    }
    public Product addItems(Product Product){
        return productRepo.save(Product);
    }
    public  List<Product> finByCategory(String category){return  productRepo.findByCategory(category);}
    public  List<Product> findByAvailability(boolean stockAvailability){return productRepo.findByStockAvailability(stockAvailability);}
    public Product updateItem(String id, Product Product) throws Exception {
        Optional<Product> itemDB = productRepo.findById(id);
        if(itemDB.isPresent()){
            Product _itemUpdateDB = itemDB.get();
            _itemUpdateDB.setName(Product.getName());
            _itemUpdateDB.setQuantity((Product.getQuantity()));
            _itemUpdateDB.setCategory((Product.getCategory()));
            _itemUpdateDB.setPrice(Product.getPrice());
            _itemUpdateDB.setStockAvailability(Product.isStockAvailability());
            productRepo.save(_itemUpdateDB);
            return _itemUpdateDB;
        }
        else {
            throw new Exception("Record not found with id : " + id);
            }
        }
        public String deleteItem(String id) throws Exception {
            Optional<Product> itemDB = productRepo.findById(id);
            if (itemDB.isPresent()){
                productRepo.deleteById(id);
                return ("Item deleted with id " + id);
            }
            else{throw  new Exception();}
        }


    }

