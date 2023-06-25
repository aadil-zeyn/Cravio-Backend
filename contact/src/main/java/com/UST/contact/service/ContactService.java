package com.UST.contact.service;

import com.UST.contact.entity.Contact;
import com.UST.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact createContact(Contact contact) {
        Contact savedContact = contactRepository.save(contact);
        return savedContact;
    }
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
