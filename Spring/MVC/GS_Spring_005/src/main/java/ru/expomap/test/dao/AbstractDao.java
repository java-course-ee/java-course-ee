package ru.expomap.test.dao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 01.12.2011
 * Time: 11:02:58
 * To change this template use File | Settings | File Templates.
 */
public interface AbstractDao<T> {

    T getById(Integer id);

    List<T> findAll();

    T create(T entyty);

    T update(T entity);

    void delete(T entity);

}
