package ru.expomap.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.expomap.test.dao.AbstractDao;
import ru.expomap.test.model.User;
import ru.expomap.test.validation.UserValidator;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    @Qualifier(value = "userDao")
    private AbstractDao userDao;

    @Autowired
    @Qualifier(value = "userValidator")
    private UserValidator userValidator;


    @ModelAttribute("users")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String get(Model model) {
        model.addAttribute("user", new User());
        return "users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{action}/{id}")
    public String handleAction(@PathVariable String id, @PathVariable String action, Model model) {
        User user = (User) userDao.getById(Integer.valueOf(id));
        System.out.println("user = " + user);
        if (user == null)
            return "redirect:/users";
        if (action.equalsIgnoreCase("edit")) {
            model.addAttribute("user", user);
            return "users";
        } else if (action.equalsIgnoreCase("delete")) {
            userDao.delete(user);
        }
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("user") User user, BindingResult result) {
        userValidator.validate(user, result);
        System.out.println("user = " + user);
        if (result.hasErrors())
            return "/users";

        userDao.update(user);
        return "redirect:/users";

    }


}
