package com.example.cg.service;

import com.example.cg.model.ProductOrder;

import java.util.List;

public interface OrderService {

    ProductOrder addOrder(ProductOrder productOrder);

    ProductOrder updateOrder(Integer orderId, ProductOrder productOrder);

    void deleteOrderById(Integer orderId);

    ProductOrder getOrderById(Integer orderId);

    List<ProductOrder> findAllOrders();
}
