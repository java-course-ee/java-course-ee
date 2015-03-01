package edu.javacourse;

import javax.ejb.Local;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@Local
public interface Greeting {

    String sayHello(String name);

}
