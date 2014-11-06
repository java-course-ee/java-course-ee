package ru.test.struts2.service;

import ru.test.struts2.entity.Account;
import ru.test.struts2.entity.Person;
import ru.test.struts2.entity.Transfer;

import java.util.List;

/**
 * @author artem.pronchakov@calisto.email
 */
public interface TransferService {
    public List<Transfer> getTransfersByPerson(Person person);

    public void proccessTransfer(Account from, Account to, double amount, String comment);
}
