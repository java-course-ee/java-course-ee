package edu.javacourse.spring.ioc.beans;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Child extends Person {
    private Adult responsible;

    public Adult getResponsible() {
        return responsible;
    }

    public void setResponsible(Adult responsible) {
        this.responsible = responsible;
    }
}
