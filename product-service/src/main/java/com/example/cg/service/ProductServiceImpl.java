package com.example.cg.service;

import com.example.cg.model.Product;
import com.example.cg.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Value("${spring.kafka.topic.create-product}")
    private String createProduct;

    @Autowired(required = false)

    KafkaTemplate kafkaTemplate;

    @Autowired
    EmailService emailService;

    @Override
    public Product addProduct(Product product) {
        Product product1 = productRepo.save(product);
        kafkaTemplate.send(createProduct, product1);
        //  kafkaTemplate.send("medium-events", product1);
        return product1;
    }

    @KafkaListener(topics = "create-product",
            groupId = "product-group")
    public void consume(Product message) {
        System.out.println("Message received -> %s" + message);
    }

    @Transactional
    @Override
    public Product updateProduct(Integer productId, Product product) {
        product.setId(productId);
        Product product1 = productRepo.save(product);
        emailService.sendEmail(product1.getProductName());
        return product1;
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

    @KafkaListener(topics = "medium-events", groupId = "my-group-id")
    public void listen(Product message) {
        System.out.println("Received message:==== " + message);
    }


}
