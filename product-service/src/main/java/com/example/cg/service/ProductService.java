package com.example.cg.service;

import com.example.cg.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    Product updateProduct(Integer productId, Product product);

    void deleteProductById(Integer productId);

    Product findProductById(Integer productId);

    List<Product> findAllProducts();
}
