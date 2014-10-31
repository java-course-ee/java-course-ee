package ru.test.struts2.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.test.struts2.dao.DAO;
import ru.test.struts2.entity.Account;

/**
 * @author artem.pronchakov@calisto.email
 */
public class AccountServiceImpl implements AccountService {

    private DAO dao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Account getAccount(Long id, boolean readonly) {
        return dao.get(Account.class, id, readonly);
    }

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

}
