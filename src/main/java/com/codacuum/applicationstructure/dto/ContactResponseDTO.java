package com.codacuum.applicationstructure.dto;

import lombok.Data;

@Data
public class ContactResponseDTO {
    private Long id;
    private String fullName;
    private String phoneNumber;
}
