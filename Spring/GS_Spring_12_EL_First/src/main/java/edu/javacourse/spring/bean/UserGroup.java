package edu.javacourse.spring.bean;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 22.07.13
 */
public class UserGroup {

    @Value("#{ systemProperties['user.name'] + ' company' }")
    private String name;
    private List<User> users;
    private User owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}
