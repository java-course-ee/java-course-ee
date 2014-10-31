package ru.test.struts2.service;

import ru.test.struts2.entity.Person;

import java.util.List;

/**
 * @author artem.pronchakov@calisto.email
 */
public interface UserService {
    public Person getPerson(Long id, boolean readonly);

    public List<Person> findAllPersons(boolean readonly);
}
