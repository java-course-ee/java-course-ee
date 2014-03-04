package ru.geminisystems.dao;


import java.util.List;
import ru.geminisystems.entity.Application;


public interface IApplicationDAO {

    void create(Application application);
    void update (Application application);
    Application getById (Long applicationId);
    List<Application> getAll();
    Application getByName(String applicationName);
    void delete (Application application);
}
