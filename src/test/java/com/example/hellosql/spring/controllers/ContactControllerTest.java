package com.example.hellosql.spring.controllers;

import com.example.hellosql.spring.entity.Contact;
import com.example.hellosql.spring.repos.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ContactControllerTest {

    @InjectMocks
    private ContactController contactController;
    @Mock
    private ContactRepository contactRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(contactController).build();
    }

    @Test
    public void getNameFilterTest() throws Exception {
        mockMvc.perform(get("/hello/contacts")).andExpect(status().is4xxClientError());
    }


    @Test
    public void getFiltredContacts() throws Exception{
        Set<Contact> set = new LinkedHashSet<>();
        set.add(new Contact("Andrey"));
        set.add(new Contact("Vasya"));
        when(contactRepository.findAll()).thenReturn(set);
        mockMvc.perform(get("/hello/contacts?nameFilter=test")).andExpect(status().isOk());
    }


}