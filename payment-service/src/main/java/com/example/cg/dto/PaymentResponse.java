package com.example.cg.dto;

import com.example.cg.entity.Payment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentResponse {
    private Integer paymentId;
    private PaymentStatus paymentStatus;
    private Integer orderId;
    private LocalDateTime paymentDate;

    public PaymentResponse(Payment payment) {
        this.paymentId = payment.getPaymentId();
        this.paymentStatus = payment.getStatus();
        this.orderId = payment.getOrderId();
        this.paymentDate = payment.getPaymentDateTime();

    }
}
