package com.gemini.spring.service;

import com.gemini.spring.dao.UserDao;
import com.gemini.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 11.04.13
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void create(User user) {
        userDao.create(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getById(Long userId) {
        return userDao.getById(userId);
    }

    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }
}
