package edu.javacourse.spring.bean;

public class SpringTestConstructor {

    private int number;
    private String name;
    private SpringTest test;

    public SpringTestConstructor(int number, String name, SpringTest test) {
        this.number = number;
        this.name = name;
        this.test = test;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public SpringTest getTest() {
        return test;
    }
}
