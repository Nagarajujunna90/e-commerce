package com.example.cg.repo;

import com.example.cg.entity.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentRequest,Integer> {
}
