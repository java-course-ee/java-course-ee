package ru.test.struts2.service;

import ru.test.struts2.entity.Account;

/**
 * @author artem.pronchakov@calisto.email
 */
public interface AccountService {
    public Account getAccount(Long id, boolean readonly);
}
