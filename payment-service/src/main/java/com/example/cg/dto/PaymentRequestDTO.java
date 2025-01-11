package com.example.cg.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PaymentRequestDTO {
    private Integer orderId;
    private PaymentMode paymentMode;
    private Double paymentAmount;
    private LocalDateTime requestedDate;

}
