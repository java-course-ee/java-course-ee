package ru.gs.test.simpleportlet;

import java.io.IOException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SimplePortlet extends GenericPortlet{

    @Override
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        
    }

    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        request.setAttribute("Name", "Vasiliy");
        getPortletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
    
    

}
