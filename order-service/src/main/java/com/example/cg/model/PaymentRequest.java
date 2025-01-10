package com.example.cg.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentRequest {
    private Integer orderId;
    private Double orderPrice;
    private String orderBy;
    private LocalDate orderDate;
}
