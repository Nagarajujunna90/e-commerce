package com.example.cg.service;


import com.example.cg.dto.UserResponse;
import com.example.cg.model.PaymentRequest;
import com.example.cg.model.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class BaseCallerServiceImpl {

    @Value("${payment-service.url}")
    private String paymentUrl;

    @Value("${payment-service.create-payment}")
    private String paymentCreate;

    @Autowired
    RestTemplate restTemplate;

    public PaymentResponse paymentRequest(PaymentRequest paymentRequest) {
        log.info("Inside basecallerserviceImpl ----" + paymentRequest + paymentUrl + paymentCreate);
        final Map<String, String> inputHeaders = new HashMap<>();
        HttpHeaders headers = createHttpHeaders(inputHeaders);
        HttpEntity<PaymentRequest> entityRequest = new HttpEntity<>(paymentRequest);
        ResponseEntity<PaymentResponse> responseEntity = restTemplate.exchange(paymentUrl + paymentCreate, HttpMethod.POST, entityRequest, PaymentResponse.class);
        return responseEntity.getBody();
    }

    public UserResponse getUserDetails(Integer userId) {
        log.info("Inside user call");
        ResponseEntity<UserResponse> responseEntity = restTemplate.getForEntity("http://localhost:7070/user/v1/user/" + userId, UserResponse.class);
        return responseEntity.getBody();
    }

    private HttpHeaders createHttpHeaders(Map<String, String> inputHeaders) {
        inputHeaders.put("accept", "application/json");
        return null;
    }
}
