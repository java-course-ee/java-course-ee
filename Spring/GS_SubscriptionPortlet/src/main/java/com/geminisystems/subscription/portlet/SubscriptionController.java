package com.geminisystems.subscription.portlet;

import com.geminisystems.subscription.domain.SBean;
import com.geminisystems.subscription.domain.SBeanValidator;
import com.geminisystems.subscription.domain.SCategory;
import com.geminisystems.subscription.domain.SType;
import com.geminisystems.subscription.service.CategoryService;
import com.geminisystems.subscription.service.SubscriptionService;
import com.geminisystems.subscription.util.SResult;
import com.ibm.ws.portletcontainer.core.impl.RenderRequestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.PortletRequestDataBinder;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Locale;


/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 19.10.2011
 * Time: 17:12:41
 * To change this template use File | Settings | File Templates.
 */

@Controller(value = "subscriptionController")
@RequestMapping(value = "VIEW")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @Autowired
    private SBeanValidator validator;

    @Autowired
    @Qualifier("messageSource")
    private MessageSource messages;

    @Autowired
    private CategoryService categoryService;

    @RenderMapping
    private String showForm(Model model, RenderRequest request, PortletRequest prRequest) {

        RenderRequestImpl renderRequestImpl = (RenderRequestImpl) request;
        HttpServletRequest r = renderRequestImpl.getHttpServletRequest();

        String action = r.getParameter("action");
        String email = r.getParameter("email");
        String rnd = r.getParameter("rnd");


        // if any link was pressed
        if (action != null && email != null && rnd != null) {
            // subscribe link pressed
            if (action.equals(SubscriptionService.ACTION_SUBSCRIBE)) {
                SResult result = service.confirm(action, email, rnd);
                model.addAttribute("result", result);
                return "message";
            }// unsubscribe/edit link pressed
            else {
                SBean bean = service.getByEmail(email);
                if (bean == null || !bean.getHash().equals(rnd)) {
                    model.addAttribute("result", new SResult(getMessage("subscription." + action + ".failure"), getMessage("subscription.link.expired"), false));
                    return "message";
                } else {
                    model.addAttribute("subscribe", bean);
                    return "edit";
                }
            }
        }

        if (!model.containsAttribute("subscribe"))
            model.addAttribute("subscribe", new SBean());
        return "subscription";


    }

    @RenderMapping(params = "action=showMessage")
    private String showMessage(Model model, RenderRequest request) {
        return "message";
    }

    @RenderMapping(params = "action=edit")
    private String showEditForm(Model model, RenderRequest request) {
        return "edit";
    }

    @ModelAttribute("allCategories")
    public List<SCategory> getSubscribeCategories(PortletPreferences preferences) {
        return categoryService.getAll();
    }

    @InitBinder
    public void initBinder(PortletRequestDataBinder binder, PortletPreferences preferences) {
        final PortletPreferences prefs = preferences;
        binder.registerCustomEditor(List.class, "categories", new CustomCollectionEditor(List.class) {
            protected Object convertElement(Object element) {
                if (element != null) {
                    Integer categoryId = Integer.parseInt(element.toString());
                    SCategory category = categoryService.getById(categoryId);
                    return category;

                }
                return null;
            }

            @Override
            public String getAsText() {
                String text = super.getAsText();
                System.out.println("text = " + text);
                return text;
            }
        });

        binder.registerCustomEditor(Enum.class, "type", new PropertyEditorSupport() {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                System.out.println("text = " + text);
                if (text.equals("USERS"))
                    setValue(SType.USERS);
                if (text.equals("MEDIA"))
                    setValue(SType.MEDIA);
            }
        });
    }

    @ActionMapping(params = "subscribe")
    private void subscribe(@ModelAttribute(value = "subscribe") SBean bean, BindingResult bindingResult, ActionResponse response, Model model) {
        validator.validate(bean, bindingResult);
        if (!bindingResult.hasErrors()) {
            SResult result = service.subscribe(bean, SubscriptionService.ACTION_SUBSCRIBE);
            model.addAttribute("result", result);
            response.setRenderParameter("action", "showMessage");
        }
    }

    @ActionMapping(params = "check")
    private void check(@ModelAttribute(value = "subscribe") SBean bean, BindingResult bindingResult, ActionResponse response, Model model) {
        bean.setHash("check");
        validator.validate(bean, bindingResult);
        if (!bindingResult.hasErrors()) {
            SResult result = new SResult();
            result.setSuccess(service.isActiveSubscription(bean));
            result.setMessage(result.isSuccess() ? getMessage("subscription.active") : getMessage("subscription.inactive"));
            model.addAttribute("result", result);
            response.setRenderParameter("action", "showMessage");
        }
    }

    @ActionMapping(params = "edit")
    private void edit(@ModelAttribute(value = "subscribe") SBean bean, BindingResult bindingResult, ActionResponse response, Model model) {
        validator.validate(bean, bindingResult);
        if (!bindingResult.hasErrors()) {
            SResult result = service.edit(bean);
            model.addAttribute("result", result);
            response.setRenderParameter("action", "showMessage");
        } else {
            //model.addAttribute("subscribe", bean);
            response.setRenderParameter("action", "edit");
        }
    }

    @ActionMapping(params = "delete")
    private void delete(@ModelAttribute(value = "subscribe") SBean bean, BindingResult bindingResult, ActionResponse response, Model model) {
        SResult result = service.delete(bean);
        model.addAttribute("result", result);
        response.setRenderParameter("action", "showMessage");
    }


    private String getMessage(String key, Object[] params) {
        return messages.getMessage(key, params, new Locale("RU"));
    }

    private String getMessage(String key) {
        return messages.getMessage(key, null, new Locale("RU"));
    }


}
