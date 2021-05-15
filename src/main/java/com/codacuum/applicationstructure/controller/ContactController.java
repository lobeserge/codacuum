package com.codacuum.applicationstructure.controller;

import com.codacuum.applicationstructure.dto.ContactRequestDTO;
import com.codacuum.applicationstructure.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping()
    ResponseEntity<?> addContact(@RequestBody ContactRequestDTO contactRequestDTO){
        contactService.addContact(contactRequestDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{contactId}")
    ResponseEntity<?> getContact(@PathVariable("contactId") Long contactId) {
        return ResponseEntity.ok(contactService.getContact(contactId));
    }

}
