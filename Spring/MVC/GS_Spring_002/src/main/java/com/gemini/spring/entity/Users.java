package com.gemini.spring.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 11.04.13
 */

@XmlRootElement(name = "users")
public class Users {

    private List<User> users;

    public Users() {
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
