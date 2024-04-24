package com.example.Inventory.service;

import com.example.Inventory.dto.ProductAddDTO;
import com.example.Inventory.model.Product;
import com.example.Inventory.repository.ProductCustomRepositoryImpl;
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

    @Autowired
    private ProductCustomRepositoryImpl productCustomRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        return  productCustomRepository.findByCategory(category);
    }
    @Override
    public List<Product> findProductByAvailability(boolean stockAvailability) {
        return productCustomRepository.findStockByAvailability(stockAvailability);
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
    }

    @Override
    public void deleteProduct(String id) {
        productRepo.deleteById(id);
    }
}
