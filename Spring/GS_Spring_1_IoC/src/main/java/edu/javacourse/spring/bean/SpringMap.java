package edu.javacourse.spring.bean;

import java.util.Map;

public class SpringMap {

    private Map<String, Float> accounts;

    public void setAccounts(Map<String, Float> accounts) {
        this.accounts = accounts;
    }

    public Map<String, Float> getAccounts() {
        return accounts;
    }
}
