package edu.javacourse.ejb;

import edu.javacourse.ejb.staff.BusinessException;
import edu.javacourse.ejb.staff.Region;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@WebServlet(name = "Servlet", urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {

    @EJB
    private ContainerManagedTransactionsEJB ejb;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        if (name == null) name = "Default Name";

        final String transaction = request.getParameter("transaction");

        response.getWriter().write("=================================== Current state:\n\n");
        printAllRegions(response);

        if ("yes".equals(transaction)) {
            response.getWriter().write("=================================== updateRegionWithTransaction:\n\n");
            try {
                ejb.updateRegionWithTransaction(new Region(1L, name));
            } catch (BusinessException ex) {
                response.getWriter().write("Error updateRegionWithTransaction: " + ex.getMessage() + "\n\n");
            }
            printAllRegions(response);
        } else if ("no".equals(transaction)) {
            response.getWriter().write("=================================== updateRegionWithNoTransaction:\n\n");
            try {
                ejb.updateRegionWithNoTransaction(new Region(1L, name));
            } catch (BusinessException ex) {
                response.getWriter().write("Error updateRegionWithNoTransaction: " + ex.getMessage() + "\n\n");
            }
            printAllRegions(response);
        }

    }

    private void printAllRegions(HttpServletResponse response) throws IOException {
        try {
            List<Region> allRegions = ejb.getAllRegions();
            for (Region region : allRegions) {
                response.getWriter().write(region + "\n\n");
            }
        } catch (BusinessException ex) {
            response.getWriter().write("Error updateRegionWithTransaction: " + ex.getMessage() + "\n\n");
        }
    }
}
