package com.example.cg.gateway_service;

import org.apache.http.HttpStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@RequestMapping("/productServiceFallBack")
	public ResponseEntity<String> userServiceFallBack(){

		return new ResponseEntity<>("Product service is down", HttpStatusCode.valueOf(HttpStatus.SC_SERVICE_UNAVAILABLE));
	}
	@RequestMapping("/orderServiceFallBack")
	public ResponseEntity<String> orderServiceFallBack(){

		return new ResponseEntity<>("Order service is down", HttpStatusCode.valueOf(HttpStatus.SC_SERVICE_UNAVAILABLE));
	}
}
