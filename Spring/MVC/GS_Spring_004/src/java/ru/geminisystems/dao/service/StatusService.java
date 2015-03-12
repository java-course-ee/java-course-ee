package ru.geminisystems.dao.service;


import ru.geminisystems.dao.IStatusDAO;
import ru.geminisystems.entity.Status;

import java.util.List;


public class StatusService {

    private IStatusDAO statusDAO;

    public IStatusDAO getStatusDAO() {
        return statusDAO;
    }

    public void setStatusDAO(IStatusDAO statusDAO) {
        this.statusDAO = statusDAO;
    }

    public void create(Status status) {
        statusDAO.create(status);
    }

    public void update(Status status) {
        statusDAO.update(status);
    }

    public List<Status> getAll() {
        return statusDAO.getAll();
    }

    public Status getById(Long statusId) {
        return statusDAO.getById(statusId);
    }

    public Status getByName(String statusName) {
        return statusDAO.getByName(statusName);
    }

    public void delete(Status status) {
        statusDAO.delete(status);
    }

    public List<Status> getOrderStatuces() {
        return statusDAO.getOrderStatuces();
    }
}
