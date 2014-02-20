package ru.test.struts2.service;

import java.util.List;
import ru.test.struts2.dao.DAO;
import ru.test.struts2.entity.Person;

/**
 *
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class UserServiceImpl implements UserService{
	
	private DAO dao;

	@Override
	public Person getPerson(Long id, boolean readonly) {
		return dao.get(Person.class, new Long(id), readonly);
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Person> findAllPersons(boolean readonly) {
		return dao.findAllPersons(readonly);
	}

}
