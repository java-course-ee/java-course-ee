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
@SessionScoped
public class UserBean {


    private List<UserBean> users = new ArrayList<UserBean>();

    private String name;
    private String surname;
    private String emal;
    private int age;
    private boolean isLoggedIn;

    public UserBean() {
    }

    public UserBean(String name, String surname, String emal, int age) {
        this.name = name;
        this.surname = surname;
        this.emal = emal;
        this.age = age;
    }

    @PostConstruct
    private void init() {
        users.add(new UserBean("Ivan", "Ivanov", "ivanov@gmail.com", 23));
        users.add(new UserBean("Petr", "Petrov", "Petrov@gmail.com", 24));
        users.add(new UserBean("Sidr", "Sidorov", "Sidorov@gmail.com", 26));
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
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

    public List<UserBean> getUsers() {
        return users;
    }

    public void setUsers(List<UserBean> users) {
        this.users = users;
    }

    public void delete(UserBean u) {
        users.remove(u);
    }

    public void addUser() {
        users.add(new UserBean(getName(), getSurname(), getEmal(), getAge()));
        this.name = "";
        this.surname = "";
        this.emal  = "";
        this.age = 0;
    }

    public String login(){
        isLoggedIn = true;
        return "home";
    }

    public String logout(){
        isLoggedIn = false;
        return "logout";
    }

}
