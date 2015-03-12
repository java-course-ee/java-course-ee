package ru.geminisystems.controller;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import ru.geminisystems.dao.service.ApplicationService;
import ru.geminisystems.dao.service.OrderService;
import ru.geminisystems.dao.service.StatusService;
import ru.geminisystems.entity.Application;
import ru.geminisystems.entity.Order;
import ru.geminisystems.entity.Status;
import ru.geminisystems.util.OrderUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderController extends SimpleFormController {

    private StatusService statusService;
    private ApplicationService applicationService;
    private OrderService orderService;

    public OrderController() {
        setCommandClass(Order.class);
        setCommandName("newOrder");
        setSessionForm(false);
        setBindOnNewForm(false);
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setStatusService(StatusService statusService) {
        this.statusService = statusService;
    }

    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        // edit order action
        if (request.getParameter("orderId") != null && request.getParameter("action").equals("edit")) {
            Order order = orderService.getById(Long.parseLong(request.getParameter("orderId")));
            request.setAttribute("editedOrder", order);
            return order;
        }
        //delete order action
        if (request.getParameter("orderId") != null && request.getParameter("action").equals("delete")) {
            orderService.delete(orderService.getById(Long.parseLong(request.getParameter("orderId"))));
        }
        // new order action
        Order order = new Order();
        return order;

    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException e) throws Exception {
        // redirect if delete action was occured
        if (request.getParameter("action") != null && request.getParameter("action").equals("delete")) {
            return new ModelAndView(new RedirectView("orders.htm"));
        }
        return super.showForm(request, response, e);
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        // retrieving page data
        HashMap<String, Object> model = new HashMap<String, Object>();
        List<Order> orders = orderService.getAll();
        List<Status> statuces = statusService.getOrderStatuces();
        List<Float> cpuList = OrderUtil.getCpuList(getServletContext());
        List<Float> hddList = OrderUtil.getHddList(getServletContext());
        List<Float> ramList = OrderUtil.getRamList(getServletContext());
        List<Application> applications = applicationService.getAll();
        model.put("statuces", statuces);
        model.put("orders", orders);
        model.put("applications", applications);
        model.put("cpuList", cpuList);
        model.put("hddList", hddList);
        model.put("ramList", ramList);
        return model;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        Order order = (Order) command;
        orderService.update(order);
        //orderService.create(order);
        return new ModelAndView(new RedirectView("orders.htm"));
    }

    //@Override
    //protected ModelAndView processFormSubmission(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, BindException e) throws Exception {
    //return super.processFormSubmission(httpServletRequest, httpServletResponse, o, e);
    //}

    @Override
    protected void onBindAndValidate(HttpServletRequest httpServletRequest, Object o, BindException e) throws Exception {
        // retrieving order if errors occures
        if (e.hasErrors()) {
            Order order = (Order) o;
            httpServletRequest.setAttribute("editedOrder", order);
        }
        super.onBindAndValidate(httpServletRequest, o, e);
    }

    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        binder.registerCustomEditor(Set.class, "applications", new CustomCollectionEditor(Set.class) {

            @Override
            protected Object convertElement(Object element) {
                if (element != null) {
                    Long applicationId = Long.parseLong(element.toString());
                    Application application = applicationService.getById(applicationId);
                    return application;

                }
                return null;
            }
        });

        binder.registerCustomEditor(Date.class, "startDate", new CustomDateEditor(dateFormat, false) {
        });

        binder.registerCustomEditor(Date.class, "finishDate", new CustomDateEditor(dateFormat, false) {
        });

        binder.registerCustomEditor(Status.class, "status", new PropertyEditorSupport() {

            public String getAsText() {
                Object value = getValue();
                if (value != null) {
                    Status status = (Status) value;
                    return status.getStatusName();
                }
                return null;
            }

            public void setAsText(String text) {
                if (text instanceof String) {
                    if (text != null && text.trim().length() > 0) {
                        Long statusId = Long.parseLong(text);
                        Status status = statusService.getById(statusId);
                        setValue(status);
                    }
                }
            }
        });
    }
}
