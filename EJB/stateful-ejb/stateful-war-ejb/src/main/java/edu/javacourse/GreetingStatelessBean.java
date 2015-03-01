package edu.javacourse;

import javax.ejb.Stateless;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@Stateless(name = "GreetingStatelessEJB")
public class GreetingStatelessBean implements Greeting {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + ". hash: " + hashCode();
    }

}
