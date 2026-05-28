package com.scm.services;

import com.scm.entities.Contact;
import java.util.List;

public interface ContactService {
    
    // Save a contact
    Contact save(Contact contact);

    // Update a contact
    Contact update(Contact contact);

    // Get all contacts
    List<Contact> getAll();

    // get contact by ID
    Contact getById(String id);

    // Delete a contact
    void delete(String id);

    // search contacts
    List<Contact> search(String name, String email, String phoneNumber);

    //get contacts by user id
    List<Contact> getByUserId(String userId);

}
