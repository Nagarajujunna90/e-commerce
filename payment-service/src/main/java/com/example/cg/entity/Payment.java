package com.example.cg.entity;

import com.example.cg.dto.PaymentMode;
import com.example.cg.dto.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private PaymentStatus status;
    private LocalDateTime paymentDateTime;
    private PaymentMode paymentMode;
    private Double paidAmount;
    private Integer orderId;


}
