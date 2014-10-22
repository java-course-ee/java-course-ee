package ru.expomap.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.expomap.test.dao.AbstractDao;
import ru.expomap.test.model.Project;
import ru.expomap.test.model.Task;
import ru.expomap.test.model.User;
import ru.expomap.test.validation.TaskValidator;

import java.beans.PropertyEditorSupport;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 02.12.2011
 * Time: 0:36:43
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class TasksController {


    @Autowired
    @Qualifier(value = "taskDao")
    private AbstractDao taskDao;

    @Autowired
    @Qualifier(value = "projectDao")
    private AbstractDao projectDao;

    @Autowired
    @Qualifier(value = "userDao")
    private AbstractDao userDao;


    @Autowired
    @Qualifier(value = "taskValidator")
    private TaskValidator taskValidator;


    @ModelAttribute("tasks")
    public List<Project> getAllTasks() {
        return taskDao.findAll();
    }

    @ModelAttribute("projects")
    public List<Project> getAllProjects() {
        return projectDao.findAll();
    }

    @ModelAttribute("users")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public String get(Model model) {
        model.addAttribute("task", new Task());
        return "tasks";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("task") Task task, BindingResult result) {
        taskValidator.validate(task, result);
        if (result.hasErrors())
            return "/tasks";

        projectDao.update(task);
        return "redirect:/tasks";

    }


    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Project.class, "project", new PropertyEditorSupport() {

            public String getAsText() {
                Object value = getValue();
                if (value != null) {
                    Project project = (Project) value;
                    return project.getName();
                }
                return null;
            }

            public void setAsText(String text) {
                if (text instanceof String) {
                    Integer projectId = Integer.parseInt(text);
                    Project project = (Project) projectDao.getById(projectId);
                    setValue(project);

                }
            }
        });

        binder.registerCustomEditor(List.class, "users", new CustomCollectionEditor(List.class) {

            protected Object convertElement(Object element) {
                if (element != null) {
                    Integer userId = Integer.parseInt(element.toString());
                    User user = (User) userDao.getById(userId);
                    return user;

                }
                return null;
            }

        });

    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{action}/{id}")
    public String handleAction(@PathVariable Integer id, @PathVariable String action, Model model) {
        Task task = (Task) taskDao.getById(id);
        if (action.equalsIgnoreCase("edit")) {
            model.addAttribute("task", task);
            return "tasks";
        } else if (action.equalsIgnoreCase("delete")) {
            taskDao.delete(task);
        }
        return "redirect:/tasks";
    }


}
