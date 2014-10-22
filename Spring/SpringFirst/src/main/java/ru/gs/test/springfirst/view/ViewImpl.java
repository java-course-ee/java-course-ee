package ru.gs.test.springfirst.view;

import ru.gs.test.springfirst.bl.Manager;

public class ViewImpl implements View {
    private Manager manager;
    private String name;
    private Integer count;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ViewImpl{" + "manager=" + manager + ", name=" + name + ", count=" + count + '}';
    }


}
