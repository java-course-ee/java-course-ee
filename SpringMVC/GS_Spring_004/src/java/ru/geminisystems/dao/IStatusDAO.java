package ru.geminisystems.dao;


import java.util.List;

import ru.geminisystems.entity.Status;


public interface IStatusDAO {
    void create(Status status);
	void update(Status status);
	List<Status> getAll();
	List<Status> getOrderStatuces();
	Status getById(Long statusId);
	Status getByName(String statusName);
	void delete(Status status);
}
