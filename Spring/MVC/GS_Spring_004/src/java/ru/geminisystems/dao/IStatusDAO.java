package ru.geminisystems.dao;


import ru.geminisystems.entity.Status;

import java.util.List;


public interface IStatusDAO {
    void create(Status status);

    void update(Status status);

    List<Status> getAll();

    List<Status> getOrderStatuces();

    Status getById(Long statusId);

    Status getByName(String statusName);

    void delete(Status status);
}
