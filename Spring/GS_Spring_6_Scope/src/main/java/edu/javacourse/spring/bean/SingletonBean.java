package edu.javacourse.spring.bean;

public class SingletonBean {

    private Integer number;
    private PrototypeBean child;
    private PrototypeBean otherChild;

    public PrototypeBean getChild() {
        return child;
    }

    public void setChild(PrototypeBean child) {
        this.child = child;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public PrototypeBean getOtherChild() {
        return otherChild;
    }

    public void setOtherChild(PrototypeBean otherChild) {
        this.otherChild = otherChild;
    }
}
