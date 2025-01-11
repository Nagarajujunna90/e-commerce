package com.example.cg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    public Integer id;
    public String firstName;
    public Integer gender;
    public String lastName;
    public Integer mobile_number;
    public String password;
    public String userName;
    public Integer addressId;
    public String motherName;
    public String fatherName;
    public String aadharNumber;
    public String email;
    public String name;
    public String panCard;

}
