package com.geminisystems.subscription.portlet;

import com.geminisystems.subscription.domain.SCategory;
import com.geminisystems.subscription.domain.SCategoryValidator;
import com.geminisystems.subscription.domain.SPath;
import com.geminisystems.subscription.service.CategoryService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.PortletRequestDataBinder;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.*;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 10.11.2011
 * Time: 16:21:39
 * To change this template use File | Settings | File Templates.
 */
@Controller(value = "configController")
@RequestMapping(value = "CONFIG")
public class ConfigController {

    private Logger logger = Logger.getLogger(ConfigController.class);
    private Logger rootLogger = Logger.getRootLogger();

    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SCategoryValidator validator;

    @RenderMapping
    private String show(Model model, RenderRequest request, PortletPreferences prefs) throws ReadOnlyException, ValidatorException, IOException {
        if (!model.containsAttribute("category"))
            model.addAttribute("category", new SCategory());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("loglevel", rootLogger.getLevel().toString());
        return "config";
    }


    @ActionMapping(params = "create")
    public void createCategory(@ModelAttribute(value = "category") SCategory category, BindingResult bindingResult, ActionResponse response, Model model) {
        validator.validate(category, bindingResult);
        if (!bindingResult.hasErrors()) {
            SCategory cat = categoryService.create(category);
            for (SPath p : category.getPaths()) {
                p.setCategory(cat);
                //categoryService.createPath(p);
            }
            categoryService.update(cat);
            model.addAttribute("category", new SCategory());
        } else {
            model.addAttribute("category", category);
        }
    }

    @InitBinder
    public void initBinder(PortletRequestDataBinder binder, PortletPreferences preferences) {
        binder.registerCustomEditor(List.class, "paths", new PropertyEditorSupport() {

            @Override
            public String getAsText() {
                List<SPath> paths = (List<SPath>) getValue();
                if (paths == null || paths.size() < 1) return "";
                StringBuilder builder = new StringBuilder();
                for (SPath path : paths) {
                    if (builder.length() > 0)
                        builder.append(", ");
                    builder.append(path.getPathValue());

                }
                return builder.toString();
            }

            public void setAsText(String text) {
                if (text instanceof String) {
                    String[] array = text.split(",");
                    List<SPath> paths = new ArrayList<SPath>();
                    for (String str : array) {
                        String path = str.trim();
                        if (path.length() < 1) continue;
                        paths.add(new SPath(path));
                    }
                    setValue(paths);

                }
            }

        });

//        binder.registerCustomEditor(List.class, "paths",  new CustomCollectionEditor(List.class) {
//
//
//            protected Object convertElement(Object element) {
//                if (element != null) {
//                    String s = element.toString();
//                    String[] array = s.split(",");
//                    System.out.println("array = " + array.length);
//                    List<SPath> paths = new ArrayList<SPath>();
//                    for (String str : array) {
//                        paths.add(new SPath(str));
//                    }
//                    return paths;
//
//                }
//                return null;
//            }
//
//            @Override
//            public String getAsText() {
//                List<SPath> paths = (List<SPath>) getValue();
//                if (paths == null || paths.size() < 1) return "";
//                StringBuilder builder = new StringBuilder();
//                for (SPath path: paths){
//                    if (builder.length() > 0)
//                        builder.append(", ");
//                    builder.append(path.getPathValue());
//
//                }
//                return builder.toString();
//            }
//        });
    }

    @ActionMapping(params = "delete")
    public void deleteCategory(@RequestParam(value = "delete") Integer categoryId) {
        categoryService.delete(categoryService.getById(categoryId));
    }


    @ActionMapping(params = "runjob")
    public void runSchedulerUserJob(Model model, ActionRequest request, ActionResponse response) {
        try {
            scheduler.triggerJob("sendUsersMailJob", Scheduler.DEFAULT_GROUP);
            model.addAttribute("message", "Scheduler started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ActionMapping(params = "runjobSMI")
    public void runSchedulerMediaJob(Model model, ActionRequest request, ActionResponse response) {
        try {
            scheduler.triggerJob("sendMediaMailJob", Scheduler.DEFAULT_GROUP);
            model.addAttribute("message", "Scheduler started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ActionMapping(params = "setLog")
    public void setLogLevel(@RequestParam(value = "logLevel") String logLevel, PortletPreferences prefs) throws ReadOnlyException, ValidatorException, IOException {
        logger.info("Set log level to " + logLevel);

        if (logLevel.equals("INFO")) rootLogger.setLevel(Level.INFO);
        if (logLevel.equals("DEBUG")) rootLogger.setLevel(Level.DEBUG);

        //prefs.setValue("logLevel", logLevel);
        //prefs.store();

    }


}
