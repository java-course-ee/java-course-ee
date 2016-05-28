package com.gemini.spring.dao;

import com.gemini.spring.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Pronchakov artem.pronchakov@trs-it.ru
 */
@Repository
public class DummDaoImpl implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(DummDaoImpl.class);

    @Override
    public void create(User user) {
        log.info("Create user: {}", user.getLogin());
    }

    @Override
    public void update(User user) {
        log.info("Update user: {}", user.getLogin());
    }

    @Override
    public User getById(Long userId) {
        log.info("get user by id: {}", userId);
        return new User(userId, "login1", "Passw0rd", "dummy@example.org");
    }

    @Override
    public List<User> getAll() {
        log.info("get all users");
        List<User> list = new ArrayList<>(3);
        list.add(new User(1L, "login1", "Passw0rd1", "dummy1@example.org"));
        list.add(new User(2L, "login2", "Passw0rd2", "dummy2@example.org"));
        list.add(new User(3L, "login3", "Passw0rd3", "dummy3@example.org"));
        return list;
    }

    @Override
    public User getByLogin(String login) {
        log.info("get user by login: {}", login);
        return new User(1L, login, "Passw0rd", "dummy@example.org");
    }

    @Override
    public void delete(User user) {
        log.info("Delete user : {}", user.getLogin());
    }
}
