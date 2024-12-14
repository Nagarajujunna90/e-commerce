package com.example.cg.controller;

import com.example.cg.model.ProductOrder;
import com.example.cg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/v1")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/order")
    public ResponseEntity<ProductOrder> addOrder(@RequestBody ProductOrder productOrder) {
        return new ResponseEntity<>(orderService.addOrder(productOrder), HttpStatus.OK);
    }

    @PutMapping(value = "/order/{orderId}")
    public ResponseEntity<ProductOrder> updateOrder(@PathVariable("orderId") Integer orderId, @RequestBody ProductOrder productOrder) {
        ProductOrder orderById = orderService.getOrderById(orderId);
        if (orderById != null) {
            ProductOrder updateOrder = orderService.updateOrder(orderId, productOrder);
            return new ResponseEntity<>(updateOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/order/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable("orderId") Integer orderId) {
        try {
            ProductOrder orderById = orderService.getOrderById(orderId);
            if (orderById != null) {
                orderService.deleteOrderById(orderId);
                return new ResponseEntity<>("Order deleted successfully", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/order/{orderId}")
    public ResponseEntity<ProductOrder> getOrderDetailsById(@PathVariable("orderId") Integer orderId) {
        ProductOrder orderById = orderService.getOrderById(orderId);
        if (orderById.getId() != null) {
            return new ResponseEntity<>(orderById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/order")
    public ResponseEntity<List<ProductOrder>> findAllOrders() {
        return new ResponseEntity<>(orderService.findAllOrders(), HttpStatus.OK);
    }

}
