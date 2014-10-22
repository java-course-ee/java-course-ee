package edu.javacourse.spring.bean;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class ThreadScope implements Scope {

    private final ThreadLocal threadScope = new ThreadLocal() {
        protected Object initialValue() {
            return new HashMap();
        }
    };

    public Object get(String name, ObjectFactory objectFactory) {
        Map scope = (Map) threadScope.get();
        Object object = scope.get(name);
        if (object == null) {
            object = objectFactory.getObject();
            scope.put(name, object);
        }
        return object;
    }

    public Object remove(String name) {
        Map scope = (Map) threadScope.get();
        return scope.remove(name);
    }

    public void registerDestructionCallback(String name, Runnable callback) {
    }

    @Override
    public Object resolveContextualObject(String string) {
        System.out.println("resolveContextualObject");
        return new Object();
    }

    @Override
    public String getConversationId() {
        System.out.println("getConversationId");
        return "tread";
    }
}
