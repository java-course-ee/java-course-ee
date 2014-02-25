package gemini.jsf;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 08.04.13
 */
@ManagedBean(name = "user")
@ViewScoped
public class UserBean {


    private String name;
    private String surname;
    private String emal;
    private int age;

    public UserBean() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmal() {
        return emal;
    }

    public void setEmal(String emal) {
        this.emal = emal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        if (name != null && surname != null) {
            return "Hello " + name + " " + surname;
        } else return "";
    }


}
