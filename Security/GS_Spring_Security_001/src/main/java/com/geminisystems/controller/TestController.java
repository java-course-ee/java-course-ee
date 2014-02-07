package com.geminisystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 20.02.2012
 * Time: 16:25:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/welcome")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("message", "Spring Security Hello World");
        return "test";

    }

}
