package ru.gs.test.springfirst.bl;

import ru.gs.test.springfirst.dao.DAO;

public class ManagerImpl implements Manager {
    private DAO dao;
    private String name;
    private Boolean isTrue;

    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(Boolean isTrue) {
        this.isTrue = isTrue;
    }

    @Override
    public String toString() {
        return "ManagerImpl{" + "dao=" + dao + ", name=" + name + ", isTrue=" + isTrue + '}';
    }


}
