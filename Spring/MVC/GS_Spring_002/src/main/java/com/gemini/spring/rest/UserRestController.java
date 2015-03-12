package com.gemini.spring.rest;

import com.gemini.spring.entity.User;
import com.gemini.spring.entity.Users;
import com.gemini.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 10.04.13
 */
@Controller
public class UserRestController {

    // private static final String VIEW_NAME = "users" ;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users", headers = {"accept=application/json", "accept=application/xml"})
    public Users getAllUsers(ModelMap model) {
        List<User> users = userService.getAll();
        return new Users(users);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}", headers = {"accept=application/json", "accept=application/xml"})
    public User getUser(@PathVariable("id") String userId) {
        User user = userService.getById(Long.parseLong(userId));
        return user;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/users/create", headers = {"accept=application/json", "accept=application/xml"})
    public String deleteUser(@RequestBody User user) {
        userService.create(user);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") String userId) {
        User user = userService.getById(Long.parseLong(userId));
        userService.delete(user);
        return "ok";
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    @ResponseBody
    public String updateUser(@PathVariable("id") String userId, @RequestBody User user) {
        user.setUserId(Long.parseLong(userId));
        userService.update(user);
        return "ok";
    }


}
