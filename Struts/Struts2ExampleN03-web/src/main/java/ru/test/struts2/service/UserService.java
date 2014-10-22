package ru.test.struts2.service;

import ru.test.struts2.entity.Person;

import java.util.List;

/**
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public interface UserService {
    public Person getPerson(Long id, boolean readonly);

    public List<Person> findAllPersons(boolean readonly);
}
