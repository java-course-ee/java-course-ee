package ru.test.struts2.dao;

import ru.test.struts2.entity.AbstractEntity;
import ru.test.struts2.entity.Person;

import java.util.List;

/**
 * @author artem.pronchakov@calisto.email
 */
public interface DAO {
    public <T extends AbstractEntity> T save(T entity, boolean evict);

    public <T extends AbstractEntity> T update(T entity, boolean evict);

    public <T extends AbstractEntity> T get(Class<T> type, Long id, boolean readonly);

    public <T extends AbstractEntity> void delete(T entity);

    public List<Person> findAllPersons(boolean readonly);
}
