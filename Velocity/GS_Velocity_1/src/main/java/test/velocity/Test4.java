package test.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 02.09.2009
 * Time: 1:27:51
 * To change this template use File | Settings | File Templates.
 */
public class Test4 {

    public Test4() throws Exception {

        Velocity.init("src/main/java/velocity.properties");
        // get Template
        Template template = Velocity.getTemplate("Test4.vm");
        // getContext
        Context context = new VelocityContext();

        int a = 3;
        int b = 5;

        String s1 = "Hello";
        String s2 = "World";

        context.put("a", a);
        context.put("b", b);
        context.put("s1", s1);
        context.put("s2", s2);

        // get Writer
        Writer writer = new StringWriter();
        // merge
        template.merge(context, writer);

        System.out.println(writer.toString());

    }
}
