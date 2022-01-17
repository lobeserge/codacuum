package com.codacuum.springbootcrud.dto;

import lombok.Data;

@Data
public class CreateStudentRequest {
    private String name;
    private String email;
    private Long age;
    private String address;
    private String department;
}
