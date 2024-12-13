package com.example.cg.controller;

import com.example.cg.dto.ProductDTO;
import com.example.cg.model.Product;
import com.example.cg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        System.out.println(productDTO);
        productService.addProduct(product);
        return new ResponseEntity<>(new Product(), HttpStatus.OK);
    }

    @PutMapping(value = "/product/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Integer productId, @RequestBody Product product) {
        System.out.println(productId+""+product);
        productService.updateProduct(productId, product);
        return new ResponseEntity<>(new Product(), HttpStatus.OK);

    }

    @DeleteMapping(value = "/product/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") Integer productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable("productId") Integer productId) {
        System.out.println(productId);
        Product productById = productService.findProductById(productId);
        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> findAllProduct() {
        List<Product> productList = productService.findAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
