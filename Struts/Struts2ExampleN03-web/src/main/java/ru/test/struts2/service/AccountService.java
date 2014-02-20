package ru.test.struts2.service;

import ru.test.struts2.entity.Account;

/**
 *
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public interface AccountService {
	public Account getAccount(Long id, boolean readonly);
}
