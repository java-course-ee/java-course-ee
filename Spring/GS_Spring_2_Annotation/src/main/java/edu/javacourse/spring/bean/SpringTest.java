package edu.javacourse.spring.bean;

import org.springframework.beans.factory.annotation.Required;

public class SpringTest {

    private Integer number;
    private SpringTestChild child;
    private SpringTestChild otherChild;

    public SpringTestChild getChild() {
        return child;
    }

    @Required
    public void setChild(SpringTestChild child) {
        this.child = child;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public SpringTestChild getOtherChild() {
        return otherChild;
    }

    public void setOtherChild(SpringTestChild otherChild) {
        this.otherChild = otherChild;
    }
}
