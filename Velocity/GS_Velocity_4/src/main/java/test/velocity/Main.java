package test.velocity;

import bean.Category;
import bean.Content;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import util.EmailUtil;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 02.09.2009
 * Time: 0:16:23
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Velocity.init("src/main/java/velocity.properties");
        //sendTextEmail();
        //sendWelcomeEmail();
        sendUpdatesEmail();

    }


    private static void sendTextEmail() {
        String text = "According to a report from Bloomberg, e-commerce behemoth Amazon is preparing to launch a set-top box this fall, in hopes that you’ll consume all of your content through its spin on the now-common device. The company is already working hard to push its Kindle line to consumers, and this box would be for people who don’t want to deal with the fanciness of Apple products";
        EmailUtil.send("gobozov@gmail.com", "Plaint text email test", text, EmailUtil.EmailType.TEXT);
    }

    private static void sendWelcomeEmail() {
        Template template = Velocity.getTemplate("welcome.vm");
        Context context = new VelocityContext();

        context.put("username", "Georgy Gobozov");
        context.put("url", "http://java-course.ru");
        context.put("sitename", "Java Course");
        context.put("subscriptionUrl", "http://java-course.ru/subscription");
        context.put("sender", "Saburov Anton");

        Writer writer = new StringWriter();
        template.merge(context, writer);
        EmailUtil.send("gobozov@gmail.com", "Welcome to java-course.ru", writer.toString(), EmailUtil.EmailType.HTML);
    }

    private static void sendUpdatesEmail() {

        Category news = new Category("News");
        news.getContent().add(new Content("News number 1", "Text blah-blah-blah", new Date()));
        news.getContent().add(new Content("News number 2", "Text2 blah-blah-blah", new Date()));
        news.getContent().add(new Content("News number 3", "Text3 blah-blah-blah", new Date()));


        Category events = new Category("Events");
        events.getContent().add(new Content("Event number 1", "Text blah-blah-blah", new Date()));
        events.getContent().add(new Content("Event number 2", "Text2 blah-blah-blah", new Date()));
        events.getContent().add(new Content("Event number 3", "Text3 blah-blah-blah", new Date()));

        Template template = Velocity.getTemplate("updates.vm");
        Context context = new VelocityContext();

        context.put("currentDate", new Date());
        context.put("categories", Arrays.asList(news, events));

        Writer writer = new StringWriter();
        template.merge(context, writer);
        EmailUtil.send("gobozov@gmail.com", "News updates", writer.toString(), EmailUtil.EmailType.HTML);

    }


}
