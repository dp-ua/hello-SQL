package com.example.hellosql.spring.controllers;


import com.example.hellosql.spring.services.ContactService;
import com.example.hellosql.spring.entity.Contact;
import com.example.hellosql.spring.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Controller    // This means that this class is a Controller
@RequestMapping(path = "/hello") // This means URL's start with /demo (after Application path)
public class ContactController extends AddController{

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ContactRepository contactRepository;

    private ContactService contactService = new ContactService();


    @GetMapping(path = "/contacts")
    public @ResponseBody
    ResponseEntity<Set<Contact>> getFiltredContacts(
            @RequestParam(name = "nameFilter", required = true) String nameFilter) {
        Set<Contact> result = contactService.getFiltredSet(contactRepository, nameFilter);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
