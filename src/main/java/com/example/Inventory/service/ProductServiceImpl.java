package com.example.Inventory.service;

import com.example.Inventory.dto.ProductAddDTO;
import com.example.Inventory.model.Product;
import com.example.Inventory.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Product> getAllGroceries() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> finByCategory(String category) {
        return  productRepo.findByCategory(category);
    }
    @Override
    public List<Product> findByAvailability(boolean stockAvailability) {
        return productRepo.findByStockAvailability(stockAvailability);
    }

    @Override
    public ProductAddDTO addProducts(ProductAddDTO productAddDTO) {
        Product product = modelMapper.map(productAddDTO, Product.class);
        Product saveProduct = productRepo.save(product);
        return  modelMapper.map(saveProduct, ProductAddDTO.class);
    }
    @Override
    public Product updateItem(String id, Product Product) {
        return null;
    }

    @Override
    public void deleteItem(String id) {
        productRepo.deleteById(id);
    }
}
