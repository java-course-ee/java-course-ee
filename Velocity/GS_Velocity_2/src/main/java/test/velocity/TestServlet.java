package test.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.view.VelocityViewServlet;
import test.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 02.09.2009
 * Time: 14:19:23
 * To change this template use File | Settings | File Templates.
 */
public class TestServlet extends VelocityViewServlet {

    private Collection products = new ArrayList();

    @Override
    public void init() throws ServletException {
        products.add(new Product("Widget", 12.99));
        products.add(new Product("Wotsit", 13.99));
        products.add(new Product("Thingy", 11.99));
        super.init();
    }

    @Override
    public Template handleRequest(HttpServletRequest request, HttpServletResponse response, Context context) {


        if (request.getParameter("submit") != null) {
            List<String> errors = new ArrayList();
            String name = request.getParameter("name");
            System.out.println("name = " + name);
            try {
                double price = Double.parseDouble(request.getParameter("price"));
                System.out.println("price = " + price);
                products.add(new Product(name, price));
            } catch (NumberFormatException e) {
                System.err.println(e);
                errors.add("Price must be a number");
            }
            context.put("errors", errors);
        }

        Template template = null;
        context.put("products", products);
        context.put("company", "Gemini Systems");
        template = getTemplate("products.vm");
        return template;
    }

}
