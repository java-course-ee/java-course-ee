package com.gemini.spring.dao;

import com.gemini.spring.entity.User;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 11.04.13
 */
public interface UserDao {

    void create(User user);

    void update(User user);

    User getById(Long userId);

    List<User> getAll();

    User getByLogin(String login);

    void delete(User user);

}
