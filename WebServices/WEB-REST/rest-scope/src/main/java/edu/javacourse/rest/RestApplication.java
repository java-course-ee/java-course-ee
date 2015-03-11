package edu.javacourse.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@ApplicationPath("rest")
public class RestApplication extends Application {

    private static Set<Class<?>> classes = new HashSet<Class<?>>();

    static {
        classes.add(RestScopeRequest.class);
//        classes.add(RestScopeSingleton.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.<Object>singleton(new RestScopeSingleton());
    }
}
