package edu.javacourse.spring.bean;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class RegionManager {

    private String name;
    private int number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void getInfo() {
        System.out.println("Name = " + name + " number= " + number);
    }

    public void throwException() {
        throw new IllegalArgumentException();
    }

}
