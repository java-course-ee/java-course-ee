package ru.test.struts2.service;

import java.util.List;
import ru.test.struts2.entity.Person;

/**
 *
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public interface UserService {
	public Person getPerson(Long id, boolean readonly);
	public List<Person> findAllPersons(boolean readonly);
}
