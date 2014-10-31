package ru.test.struts2.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.test.struts2.dao.DAO;
import ru.test.struts2.entity.Person;

import java.util.List;

/**
 * @author artem.pronchakov@calisto.email
 */
public class UserServiceImpl implements UserService {

    private DAO dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
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
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Person> findAllPersons(boolean readonly) {
        return dao.findAllPersons(readonly);
    }

}
