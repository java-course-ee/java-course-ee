package edu.javacourse.spring.ioc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.javacourse.spring.ioc.beans.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class InstantiationExample {

    private static Logger log = LoggerFactory.getLogger(InstantiationExample.class);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        log.debug("\n\n\n");

        Person person = context.getBean("person-default-constructor", Person.class);
        log.debug("Default Constructor: {}", gson.toJson(person));

        person = context.getBean("person-specific-constructor", Person.class);
        log.debug("Specific Constructor: {}", gson.toJson(person));

        person = context.getBean("person-factory-method", Person.class);
        log.debug("Factory Method: {}", gson.toJson(person));

        person = context.getBean("person-factory-method-with-arguments", Person.class);
        log.debug("Factory Method with Arguments: {}", gson.toJson(person));

    }

}
