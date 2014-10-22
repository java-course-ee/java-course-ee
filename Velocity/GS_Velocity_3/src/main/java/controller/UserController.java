package controller;

import entity.User;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 03.09.2009
 * Time: 23:55:38
 * To change this template use File | Settings | File Templates.
 */
public class UserController extends SimpleFormController {

    private UserService userService;

    public UserController() {
        setCommandClass(User.class);
        setCommandName("newUser");
        setSessionForm(false);
        setBindOnNewForm(false);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
        List<User> users = userService.getAll();
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("users", users);
        return model;
    }

    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        User user = (User) command;
        userService.update(user);
        return new ModelAndView(new RedirectView("users.htm"));
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        if (userId != null && request.getParameter("action").equals("edit")) {
            User user = userService.getById(Long.parseLong(userId));
            return user;
        }
        if (userId != null && request.getParameter("action").equals("delete")) {
            userService.delete(userService.getById(Long.parseLong(userId)));
        }
        User user = new User();
        return user;
    }


    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException e) throws Exception {
        // redirect if delete action was occured
        if (request.getParameter("action") != null && request.getParameter("action").equals("delete")) {
            return new ModelAndView(new RedirectView("users.htm"));
        }
        return super.showForm(request, response, e);    //To change body of overridden methods use File | Settings | File Templates.
    }

}
