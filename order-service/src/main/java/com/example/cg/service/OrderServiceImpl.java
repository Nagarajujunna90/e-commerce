package com.example.cg.service;

import com.example.cg.model.PaymentRequest;
import com.example.cg.model.PaymentResponse;
import com.example.cg.model.ProductOrder;
import com.example.cg.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BaseCallerServiceImpl baseCallerService;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ProductOrder addOrder(ProductOrder productOrder) {
        ProductOrder productOrder1 = orderRepository.save(productOrder);
        PaymentRequest paymentRequest=new PaymentRequest();
        paymentRequest.setOrderId(productOrder1.getId());
        paymentRequest.setOrderPrice(productOrder1.getProductPrice());
        paymentRequest.setOrderDate(LocalDate.now());
        paymentRequest.setOrderBy(productOrder1.getOrderedBy());
        PaymentResponse paymentResponse = baseCallerService.paymentRequest(paymentRequest);
        System.out.println(paymentResponse);
        return productOrder;
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
