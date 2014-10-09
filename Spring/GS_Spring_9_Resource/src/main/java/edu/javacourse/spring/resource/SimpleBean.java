package edu.javacourse.spring.resource;

import org.springframework.core.io.Resource;

public class SimpleBean {

    private Resource template;

    public Resource getTemplate() {
        return template;
    }

    public void setTemplate(Resource template) {
        this.template = template;
    }
}
