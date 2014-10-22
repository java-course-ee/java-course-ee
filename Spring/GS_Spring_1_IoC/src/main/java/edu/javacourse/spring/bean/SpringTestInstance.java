package edu.javacourse.spring.bean;

public class SpringTestInstance {

    private static SpringTestInstance instance;

    private SpringTestInstance() {
    }

    public static synchronized SpringTestInstance getInstance() {
        System.out.println("getInstance is called");
        if (instance == null) {
            instance = new SpringTestInstance();
            System.out.println("Instance is created");
        }
        return instance;
    }

    public void sayHello() {
        System.out.println("Hello from Instance");
    }
}
