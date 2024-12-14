package com.example.cg.service;

import com.example.cg.model.Product;
import com.example.cg.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;


    @Override
    public Product addProduct(Product product) {
        System.out.println(product);
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Integer productId, Product product) {
        product.setId(productId);
        return productRepo.save(product);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public Product findProductById(Integer productId) {
        return productRepo.findById(productId).orElse(new Product());
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }
}
