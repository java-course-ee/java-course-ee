package com.gemini.spring.rest;

import com.gemini.spring.entity.User;
import com.gemini.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 11.04.13
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users.html")
    public String getAllUsers(ModelMap model) {
        List<User> users = userService.getAll();
        model.put("users", users);
        return "users";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}.html")
    public String getUser(@PathVariable("id") String userId, ModelMap model) {
        User user = userService.getById(Long.parseLong(userId));
        model.put("user", user);
        return "user";
    }

}
