package ru.test.struts2.service;

import ru.test.struts2.dao.DAO;
import ru.test.struts2.entity.Account;

/**
 *
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public class AccountServiceImpl implements AccountService{
	
	private DAO dao;

	@Override
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
