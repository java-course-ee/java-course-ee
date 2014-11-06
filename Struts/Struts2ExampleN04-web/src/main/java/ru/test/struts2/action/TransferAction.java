package ru.test.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.test.struts2.entity.Account;
import ru.test.struts2.entity.Person;
import ru.test.struts2.service.AccountService;
import ru.test.struts2.service.TransferService;
import ru.test.struts2.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author artem.pronchakov@calisto.email
 */
public class TransferAction extends ActionSupport implements SessionAware {
    private Logger log = LoggerFactory.getLogger(TransferAction.class);

    private TransferService transferService;
    private UserService userService;
    private AccountService accountService;

    private Map session;

    private Person person;
    private List<Account> accountList;
    private Account fromAccount;
    private Long fromAccountVal;
    private List<Person> allPersons;
    private Person toPerson;
    private Long toPersonVal;
    private Account toPersonAccount;
    private Long toPersonAccountVal;
    private double amount;
    private String comment;


    public String transferOne() throws Exception {
        person = userService.getPerson(Long.valueOf("1"), false);
        allPersons = userService.findAllPersons(false);
        getSession().put("person", person);
        return "success";
    }

    public String transferTwo() throws Exception {
        person = (Person) getSession().get("person");
        toPerson = userService.getPerson(toPersonVal, false);

        getSession().put("toPerson", toPerson);
        return "success";
    }

    public String doTransfer() throws Exception {
        fromAccount = accountService.getAccount(fromAccountVal, false);
        toPersonAccount = accountService.getAccount(toPersonAccountVal, false);

        try {
            transferService.proccessTransfer(fromAccount, toPersonAccount, amount, comment);

            getSession().remove("toPerson");

            return "success";
        } catch (Throwable ex) {
            log.error("EXCEPTION: {}", ex.getMessage());
            getSession().put("fromAccount", fromAccount);
            getSession().put("toPersonAccount", toPersonAccount);
            return "failure";
        }

    }

    public String listAccounts() throws Exception {
        person = userService.getPerson(Long.valueOf("1"), false);

        return "success";
    }

    public String listTransfers() throws Exception {
        fromAccount = accountService.getAccount(fromAccountVal, false);
        return "success";
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public TransferService getTransferService() {
        return transferService;
    }

    public void setTransferService(TransferService transferService) {
        this.transferService = transferService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Person getToPerson() {
        return toPerson;
    }

    public void setToPerson(Person toPerson) {
        this.toPerson = toPerson;
    }

    public List<Person> getAllPersons() {
        return allPersons;
    }

    public void setAllPersons(List<Person> allPersons) {
        this.allPersons = allPersons;
    }

    public Account getToPersonAccount() {
        return toPersonAccount;
    }

    public void setToPersonAccount(Account toPersonAccount) {
        this.toPersonAccount = toPersonAccount;
    }

    public Map getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Long getToPersonVal() {
        return toPersonVal;
    }

    public void setToPersonVal(Long toPersonVal) {
        this.toPersonVal = toPersonVal;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getFromAccountVal() {
        return fromAccountVal;
    }

    public void setFromAccountVal(Long fromAccountVal) {
        this.fromAccountVal = fromAccountVal;
    }

    public Long getToPersonAccountVal() {
        return toPersonAccountVal;
    }

    public void setToPersonAccountVal(Long toPersonAccountVal) {
        this.toPersonAccountVal = toPersonAccountVal;
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
