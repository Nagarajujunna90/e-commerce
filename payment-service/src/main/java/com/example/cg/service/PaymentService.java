package com.example.cg.service;

import com.example.cg.dto.PaymentRequestDTO;
import com.example.cg.dto.PaymentResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    PaymentResponse makePayment(PaymentRequestDTO paymentRequestDTO);

    PaymentResponse getPaymentById(Integer paymentId);

    void deletePaymentById(Integer paymentId);

    PaymentResponse updatePayment(PaymentRequestDTO paymentRequestDTO, Integer paymentId);
}
