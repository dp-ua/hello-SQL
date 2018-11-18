package com.example.hellosql.spring.controllers;

import com.example.hellosql.spring.services.ContactService;
import com.example.hellosql.spring.entity.Contact;
import com.example.hellosql.spring.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * Additional controller to facilitate the addition of records in the database and control their content
 */
public class AddController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ContactService contactService;

    @GetMapping(path = "/add")
    public String main(Map<String, Object> model) {
        String ipAddress = request.getRemoteAddr() + "";
        model.put("contacts", contactService.getFiltredSet(contactRepository, ""));
        return "add";
    }

    @PostMapping(path = "/add")
    public String add(@RequestParam String name, Map<String, Object> model) {
        String ipAddress = request.getRemoteAddr() + "";
        Contact result = contactService.addToRepo(new Contact(name), contactRepository);

        model.put("contacts", contactService.getFiltredSet(contactRepository, ""));
        return "add";
    }
}
