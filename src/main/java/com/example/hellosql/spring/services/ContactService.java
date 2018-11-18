package com.example.hellosql.spring.services;

import com.example.hellosql.spring.entity.Contact;
import com.example.hellosql.spring.repos.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ContactService {
    public Set<Contact> getFiltredSet(ContactRepository contactRepository, String filter) {

        Set<Contact> set = new LinkedHashSet<>((Collection<? extends Contact>) contactRepository.findAll());
        set.removeIf(o -> o.getName().matches(filter));

        return set;
    }

    public Contact addToRepo(Contact contact, ContactRepository contactRepository) {
        Contact save = contactRepository.save(contact);
        return save;
    }

}
