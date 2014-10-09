package edu.javacourse.spring.bean;

public class SpringTestChild {


    private String hello;

    public String getHello() {
        System.out.println("Unique id of object = " + System.identityHashCode(this));
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
