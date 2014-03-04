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
import ru.expomap.test.model.Project;
import ru.expomap.test.validation.ProjectValidator;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 01.12.2011
 * Time: 18:16:00
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ProjectsController {

    @Autowired
    @Qualifier(value = "projectDao")
    private AbstractDao projectDao;

    @Autowired
    @Qualifier(value = "projectValidator")
    private ProjectValidator projectValidator;


    @RequestMapping("/")
    public String foo() {
        return "redirect:/projects";
    }


    @ModelAttribute("projects")
    public List<Project> getAllProjects() {
        return projectDao.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects")
    public String get(Model model) {
        model.addAttribute("project", new Project());
        return "projects";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects/{action}/{id}")
    public String handleAction(@PathVariable Integer id, @PathVariable String action, Model model) {
        Project project = (Project) projectDao.getById(id);
        if (action.equalsIgnoreCase("edit")) {
            model.addAttribute("project", project);
            return "projects";
        } else if (action.equalsIgnoreCase("delete")) {
            projectDao.delete(project);
        }
        return "redirect:/projects";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("project") Project project, BindingResult result) {
        projectValidator.validate(project, result);
        if (result.hasErrors())
            return "/projects";

        projectDao.update(project);
        return "redirect:/projects";

    }


}
