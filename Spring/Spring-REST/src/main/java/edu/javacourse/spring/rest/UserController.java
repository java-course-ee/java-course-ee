package edu.javacourse.spring.rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
@RestController
public class UserController {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1L, "User 1", new Date()));
        users.add(new User(2L, "User 2", new Date()));
        users.add(new User(3L, "User 3", new Date()));
    }

    @RequestMapping(name = "/user", method = RequestMethod.GET, params = {"id"})
    public User getUser(@RequestParam(value = "id", required = true) Long id) {
        for (User user: users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @RequestMapping(name = "/user", method = RequestMethod.POST)
    public void addUser(@RequestBody(required = true) User user) {
        users.add(user);
    }

    @RequestMapping(name = "/user", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return users;
    }

}
