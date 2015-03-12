package com.gemini.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Author: Georgy Gobozov
 * Date: 11.04.13
 */
@Controller
public class AjaxController {

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public String getAjaxPage() {
        return "ajax";
    }


    @RequestMapping(value = "/helloajax", method = RequestMethod.GET)
    public
    @ResponseBody
    String sayHello() {
        return "Hello Ajax!";
    }

    @RequestMapping(value = "/plus", method = RequestMethod.GET)
    public
    @ResponseBody
    String plus(@RequestParam String d1, @RequestParam String d2, HttpServletResponse response) {

        try {
            return String.valueOf(Integer.parseInt(d1) + Integer.parseInt(d2));
        } catch (Exception e) {
            return "Error. Arguments must be a digits!";
        }

    }


}
