package com.gemini.spring.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Author: Georgy Gobozov
 * Date: 11.04.13
 */
@XmlRootElement(name = "user")
public class User {

    private Long userId;

    private String login;

    private String password;

    private String email;

    public User() {
    }

    public User(Long userId, String login, String password, String email) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}