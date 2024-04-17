package com.example.Inventory.service;

import com.example.Inventory.dto.ProductAddDTO;
import com.example.Inventory.model.Product;
import com.example.Inventory.repository.ProductRepository;
import com.example.Inventory.utils.Utils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Utils utils;
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        return  productRepo.findByCategory(category);
    }
    @Override
    public List<Product> findProductByAvailability(boolean stockAvailability) {
        return productRepo.findByStockAvailability(stockAvailability);
    }

    @Override
    public ProductAddDTO addProducts(ProductAddDTO productAddDTO) {
        Product product = modelMapper.map(productAddDTO, Product.class);
        Product saveProduct = productRepo.save(product);
        return  modelMapper.map(saveProduct, ProductAddDTO.class);
    }
    @Override
    public Product updateProductById(String id, Product product) {
        Optional<Product> existingProductOptional = productRepo.findById(id);
        if (existingProductOptional.isEmpty()){
            return null;
        }
        Product existingProduct = existingProductOptional.get();
        utils.mergeEntities(existingProduct, product);
        productRepo.save(existingProduct);
        return existingProduct;


//        Product existingProduct = productRepo.findById(id).orElseThrow(()-> new NoSuchElementException("No product found with give id " + id));
//        HashMap<String, String> details = new HashMap<>();
//        details.put("name", "Macbook");
//        details.put("price", String.valueOf(400000));
//        Query query = new Query();
//        Update update = new Update();
//        query.addCriteria(Criteria.where("_id").is(id));
//        for(Map.Entry<String, String> entry : details.entrySet()){
//            update.set(entry.getKey(), entry.getValue());
//            mongoTemplate.updateMulti(query,update, Product.class);
//
//        }
//        update.set("name",details.get("name"));
//        mongoTemplate.updateMulti(query,update, Product.class);

//
//        existingProduct.setName(productUpdateDTO.getName());
//        existingProduct.setCategory(productUpdateDTO.getCategory());
//        existingProduct.setQuantity(productUpdateDTO.getQuantity());
//        existingProduct.setPrice(productUpdateDTO.getPrice());
//        existingProduct.setLastUpdateTime(new Date());
//        Product updateExistingProduct = productRepo.save(existingProduct);
//        return modelMapper.map(updateExistingProduct, ProductUpdateDTO.class);
    }

    @Override
    public void deleteProduct(String id) {
        productRepo.deleteById(id);
    }
}
