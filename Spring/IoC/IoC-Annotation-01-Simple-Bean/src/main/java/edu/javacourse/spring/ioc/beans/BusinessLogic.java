package edu.javacourse.spring.ioc.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
@Component
public class BusinessLogic {

    @Autowired
    private DAO dao;

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }
}
