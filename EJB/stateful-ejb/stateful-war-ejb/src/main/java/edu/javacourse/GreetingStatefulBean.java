package edu.javacourse;

import javax.ejb.Stateful;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@Stateful(name = "GreetingStatefulEJB")
public class GreetingStatefulBean implements Greeting {

    @Override
    public String sayHello(String name) {
        return "Hello " + name + ". hash: " + hashCode();
    }

}
