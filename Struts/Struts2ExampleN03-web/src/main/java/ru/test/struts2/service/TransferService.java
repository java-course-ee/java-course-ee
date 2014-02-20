package ru.test.struts2.service;

import java.util.List;
import ru.test.struts2.entity.Account;
import ru.test.struts2.entity.Person;
import ru.test.struts2.entity.Transfer;

/**
 *
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public interface TransferService {
	public List<Transfer> getTransfersByPerson(Person person);
	public void proccessTransfer(Account from, Account to, double amount, String comment);
}
