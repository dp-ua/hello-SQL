package com.example.hellosql.spring.services;

import com.example.hellosql.spring.entity.Contact;
import com.example.hellosql.spring.repos.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;
    @InjectMocks
    private ContactService contactService = new ContactService();

    @Test
    public void getFiltredSet() {
        Set<Contact> set = new LinkedHashSet<>();
        set.add(new Contact("Andrey"));
        set.add(new Contact("Vasya"));
        when(contactRepository.findAll()).thenReturn(set);
        Set<Contact> taked = contactService.getFiltredSet(contactRepository, "");
        assertEquals(2, taked.size());
    }

    @Test
    public void addToRepo() {
        Contact contact =new Contact("Test name");
        when(contactRepository.save(contact)).thenReturn(new Contact("Test name"));
        Contact saved = contactService.addToRepo(contact, contactRepository);
        assertEquals("Test name", saved.getName());
    }
}