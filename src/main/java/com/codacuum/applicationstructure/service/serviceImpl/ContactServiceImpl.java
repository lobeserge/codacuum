package com.codacuum.applicationstructure.service.serviceImpl;

import com.codacuum.applicationstructure.dto.ContactRequestDTO;
import com.codacuum.applicationstructure.dto.ContactResponseDTO;
import com.codacuum.applicationstructure.model.Contact;
import com.codacuum.applicationstructure.repository.ContactRepository;
import com.codacuum.applicationstructure.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl  implements ContactService {

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void addContact(ContactRequestDTO contactRequestDTO) {
        Contact contact = new Contact();
        contact.setFullName(contactRequestDTO.getFullName());
        contact.setPhoneNumber(contactRequestDTO.getPhoneNumber());
        contactRepository.save(contact);
    }

    @Override
    public ContactResponseDTO getContact(Long contactId) {
        Contact contact = contactRepository.findById(contactId).get(); //could first throw and exception using an optional

        ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
        contactResponseDTO.setId(contact.getId());
        contactResponseDTO.setFullName(contact.getFullName());
        contactResponseDTO.setPhoneNumber(contact.getPhoneNumber());

        return contactResponseDTO;

    }
}
