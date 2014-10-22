package test.velocity;

import bean.Product;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 02.09.2009
 * Time: 1:49:52
 * To change this template use File | Settings | File Templates.
 */
public class Test6 {

    public Test6() throws Exception {
        Velocity.init("src/main/java/velocity.properties");

        Template template = Velocity.getTemplate("Test6.vm");
        Context context = new VelocityContext();

        Collection products = new ArrayList();

        products.add(new Product("Widget", 12.99));
        products.add(new Product("Wotsit", 13.99));
        products.add(new Product("Thingy", 11.99));

        context.put("products", products);

        //  Writer writer = new StringWriter();
        //  template.merge(context, writer);
        //  System.out.println(writer.toString());


        Template template2 = Velocity.getTemplate("Test7.vm");
        Writer writer2 = new StringWriter();
        template2.merge(context, writer2);
        System.out.println(writer2.toString());


    }
}
