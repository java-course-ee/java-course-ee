package ru.gs.test.springfirst.dao;

import java.util.UUID;

public class DAOImpl implements DAO {
    private String name;
    private String uuid = UUID.randomUUID().toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DAOImpl{" + "name=" + name + ", uuid=" + uuid + '}';
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
