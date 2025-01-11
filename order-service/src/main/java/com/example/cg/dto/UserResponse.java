package com.example.cg.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String panCard;
    private String aadharNumber;
    private String address;
}
