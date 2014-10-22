package ru.test.struts2.service;

import ru.test.struts2.entity.Account;
import ru.test.struts2.entity.Person;
import ru.test.struts2.entity.Transfer;

import java.util.List;

/**
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public interface TransferService {
    public List<Transfer> getTransfersByPerson(Person person);

    public void proccessTransfer(Account from, Account to, double amount, String comment);
}
