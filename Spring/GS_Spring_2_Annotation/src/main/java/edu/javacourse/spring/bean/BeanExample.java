package edu.javacourse.spring.bean;

import org.springframework.beans.factory.annotation.Value;

public class BeanExample {

    @Value("String for BeanExample")
    private String basicString;

    public String getBasicString() {
        return basicString;
    }

    public void setBasicString(String basicString) {
        this.basicString = basicString;
    }
}
