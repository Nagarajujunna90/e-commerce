package com.example.cg.controller;

import com.example.cg.dto.PaymentRequestDTO;
import com.example.cg.dto.PaymentResponse;
import com.example.cg.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/v1")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/pay")
    public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        PaymentResponse paymentResponse = paymentService.makePayment(paymentRequestDTO);
        return new ResponseEntity<>(paymentResponse,HttpStatus.OK);
    }

    @PostMapping("/payment/{paymentId}")
    public ResponseEntity<PaymentResponse> updatePayment(@RequestBody PaymentRequestDTO paymentRequestDTO, @PathVariable Integer paymentId) {
        paymentService.updatePayment(paymentRequestDTO, paymentId);
        return null;
    }

    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<PaymentResponse> getPaymentById(Integer paymentId) {
        PaymentResponse paymentResponse = paymentService.getPaymentById(paymentId);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/payment/{paymentId}")
    public ResponseEntity<String> deletePaymentById(Integer paymentId) {
        paymentService.deletePaymentById(paymentId);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
