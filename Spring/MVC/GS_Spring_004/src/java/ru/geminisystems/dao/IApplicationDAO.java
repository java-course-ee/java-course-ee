package ru.geminisystems.dao;


import ru.geminisystems.entity.Application;

import java.util.List;


public interface IApplicationDAO {

    void create(Application application);

    void update(Application application);

    Application getById(Long applicationId);

    List<Application> getAll();

    Application getByName(String applicationName);

    void delete(Application application);
}
