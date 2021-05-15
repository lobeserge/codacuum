package com.codacuum.applicationstructure.service;

import com.codacuum.applicationstructure.dto.ContactRequestDTO;
import com.codacuum.applicationstructure.dto.ContactResponseDTO;

public interface ContactService {
    void addContact(ContactRequestDTO contactRequestDTO);
    ContactResponseDTO getContact(Long contactId);
}
