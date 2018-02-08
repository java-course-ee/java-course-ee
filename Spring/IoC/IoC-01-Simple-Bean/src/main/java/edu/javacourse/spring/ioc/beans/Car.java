package edu.javacourse.spring.ioc.beans;

import java.util.Date;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Car {

    private Long id;
    private String model;
    private int year;
    private Date lastService;
    private Person owner;

    public Car() {
    }

    public Car(Long id, String model, int year, Date lastService, Person owner) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.lastService = lastService;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getLastService() {
        return lastService;
    }

    public void setLastService(Date lastService) {
        this.lastService = lastService;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
