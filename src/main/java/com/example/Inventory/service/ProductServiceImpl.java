package com.example.Inventory.service;

import com.example.Inventory.dto.ProductAddDTO;
import com.example.Inventory.dto.ProductUpdateDTO;
import com.example.Inventory.model.Product;
import com.example.Inventory.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ModelMapper modelMapper;
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
    public ProductUpdateDTO updateProductById(String id, ProductUpdateDTO productUpdateDTO) {
        Product existingProduct = productRepo.findById(id).orElseThrow(()-> new NoSuchElementException("No product found with give id " + id));
        existingProduct.setName(productUpdateDTO.getName());
        existingProduct.setCategory(productUpdateDTO.getCategory());
        existingProduct.setQuantity(productUpdateDTO.getQuantity());
        existingProduct.setPrice(productUpdateDTO.getPrice());
        existingProduct.setLastUpdateTime(new Date());
        Product updateExistingProduct = productRepo.save(existingProduct);
        return modelMapper.map(updateExistingProduct, ProductUpdateDTO.class);

    }
    @Override
    public void deleteProduct(String id) {
        productRepo.deleteById(id);
    }
}
