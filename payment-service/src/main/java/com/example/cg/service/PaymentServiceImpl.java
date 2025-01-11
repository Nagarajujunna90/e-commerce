package com.example.cg.service;

import com.example.cg.dto.PaymentMode;
import com.example.cg.dto.PaymentRequestDTO;
import com.example.cg.dto.PaymentResponse;
import com.example.cg.dto.PaymentStatus;
import com.example.cg.entity.Payment;
import com.example.cg.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    @Override
    public PaymentResponse makePayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment();
        payment = mapPaymentDetails(payment, paymentRequestDTO);
        Payment savedResponse = paymentRepo.save(payment);
        PaymentResponse paymentResponse = new PaymentResponse(savedResponse);
        return paymentResponse;
    }

    private Payment mapPaymentDetails(Payment payment, PaymentRequestDTO paymentRequestDTO) {
        payment.setPaymentMode(PaymentMode.UPI);
        payment.setPaymentDateTime(LocalDateTime.now());
        payment.setStatus(PaymentStatus.REQUESTED);
        payment.setPaidAmount(paymentRequestDTO.getPaymentAmount());
        payment.setOrderId(paymentRequestDTO.getOrderId());
        return payment;
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
        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        paymentRepo.save(payment);
        return null;
    }
}
