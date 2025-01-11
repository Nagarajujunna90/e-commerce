package com.example.cg.service;

import com.example.cg.dto.PaymentRequestDTO;
import com.example.cg.dto.PaymentResponse;
import com.example.cg.entity.PaymentRequest;
import com.example.cg.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    @Override
    public PaymentResponse makePayment(PaymentRequestDTO paymentRequestDTO) {
        PaymentRequest paymentRequest = new PaymentRequest();
        PaymentRequest request = paymentRepo.save(paymentRequest);
        return null;
    }

    @Override
    public PaymentResponse getPaymentById(Integer paymentId) {
        return null;
    }

    @Override
    public void deletePaymentById(Integer paymentId) {

    }

    @Override
    public PaymentResponse updatePayment(PaymentRequestDTO paymentRequestDTO, Integer paymentId) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPaymentId(paymentId);
        paymentRepo.save(paymentRequest);
        return null;
    }
}
