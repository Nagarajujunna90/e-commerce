package com.example.cg.service;

import com.example.cg.model.ProductOrder;
import com.example.cg.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ProductOrder addOrder(ProductOrder productOrder) {
        return orderRepository.save(productOrder);
    }

    @Override
    public ProductOrder updateOrder(Integer orderId, ProductOrder productOrder) {
        return orderRepository.save(productOrder);
    }

    @Override
    public void deleteOrderById(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public ProductOrder getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElse(new ProductOrder());
    }

    @Override
    public List<ProductOrder> findAllOrders() {
        return orderRepository.findAll();
    }
}
