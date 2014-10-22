package com.geminisystems.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 20.02.2012
 * Time: 16:25:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ContactsController {


    private List<String> contacts = new ArrayList<String>();

    public ContactsController() {
        contacts.add("Vova");
        contacts.add("Vanya");
        contacts.add("Petya");
    }


    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER') or hasRole ('ROLE_ADMIN')")
    public String addContact(@RequestParam("contact") String contact) {
        contacts.add(contact);
        return "redirect:/contacts";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/contacts/remove/{contact}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteContact(@PathVariable String contact) {
        contacts.remove(contact);
        return "redirect:/contacts";
    }


}
