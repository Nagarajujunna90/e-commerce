package com.example.cg.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "productOrder")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private LocalDateTime orderedTime;
    private String orderedBy;
    private String address;
    private Double productPrice;

}

