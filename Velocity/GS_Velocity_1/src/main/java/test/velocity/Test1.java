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
 * Time: 1:10:09
 * To change this template use File | Settings | File Templates.
 */
public class Test1 {

    public Test1() throws Exception {

        //init
        Velocity.init("Velocity/GS_Velocity_1/src/main/java/velocity.properties");
        // get Template
        Template template = Velocity.getTemplate("Test1.vm");
        // getContext
        Context context = new VelocityContext();
        // get Writer
        Writer writer = new StringWriter();
        // merge
        template.merge(context, writer);

        System.out.println(writer.toString());

    }
}
