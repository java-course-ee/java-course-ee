package ru.gs.test.simpleportlet;

import javax.portlet.*;
import java.io.IOException;

public class SimplePortlet extends GenericPortlet {

    @Override
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {

    }

    @Override
    protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        request.setAttribute("Name", "Vasiliy");
        getPortletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }


}
