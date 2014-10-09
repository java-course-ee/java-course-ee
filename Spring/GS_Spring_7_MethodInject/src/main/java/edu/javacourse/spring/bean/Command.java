package edu.javacourse.spring.bean;

public class Command {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void execute() {
        System.out.println("Command with state '" + state + "' is executed:" + hashCode());
    }
}
