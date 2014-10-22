package ru.test.struts2.entity;

import java.io.Serializable;

/**
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class LoginBean implements Serializable {
    private String username;
    private String password;

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginBean() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
