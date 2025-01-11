package com.example.cg.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ProductDTO {
    @JsonProperty(value = "id")
    private Integer id;
    private String productName;
    private String productDescription;
    private Double price;
    private LocalDate manufacturedDate;
    private String retailer;
}
