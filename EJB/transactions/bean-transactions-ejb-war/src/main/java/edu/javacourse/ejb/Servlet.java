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
    private BeanManagedTransactionsEJB ejb;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        if (name == null) name = "Default Name";

        final String transaction = request.getParameter("rollback");

        response.getWriter().write("=================================== Current state:\n\n");
        printAllRegions(response);

        if ("yes".equals(transaction)) {
            response.getWriter().write("=================================== updateRegionWithTransactionRollback:\n\n");
            try {
                ejb.updateRegionWithTransactionRollback(new Region(1L, name));
            } catch (BusinessException ex) {
                response.getWriter().write("Error updateRegionWithTransactionRollback: " + ex.getMessage() + "\n\n");
            }
            printAllRegions(response);
        } else if ("no".equals(transaction)) {
            response.getWriter().write("=================================== updateRegionWithTransactionCommit:\n\n");
            try {
                ejb.updateRegionWithTransactionCommit(new Region(1L, name));
            } catch (BusinessException ex) {
                response.getWriter().write("Error updateRegionWithTransactionCommit: " + ex.getMessage() + "\n\n");
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
            response.getWriter().write("Error updateRegionWithTransactionRollback: " + ex.getMessage() + "\n\n");
        }
    }
}
