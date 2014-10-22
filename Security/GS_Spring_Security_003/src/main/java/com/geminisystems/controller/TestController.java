package com.geminisystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 20.02.2012
 * Time: 16:25:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TestController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";

    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        return "login";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        return "login";

    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        model.addAttribute("message", "Hello Admin!");
        return "admin";

    }


    @RequestMapping(method = RequestMethod.GET, value = "/welcome")
    public String test(Model model, Principal principal) {
        String name = principal.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "Spring Security Hello World");
        return "test";

    }


}
