package com.gemini.spring.service;

import com.gemini.spring.dao.UserDao;
import com.gemini.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: Georgy Gobozov
 * Date: 11.04.13
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void create(User user) {
        userDao.create(user);
    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    public User getById(Long userId) {
        return userDao.getById(userId);
    }

    @Transactional
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }
}
