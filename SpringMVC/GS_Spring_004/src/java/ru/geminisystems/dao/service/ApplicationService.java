package ru.geminisystems.dao.service;


import ru.geminisystems.dao.IApplicationDAO;
import ru.geminisystems.entity.Application;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 14.07.2009
 * Time: 17:19:24
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationService {

    private IApplicationDAO applicationDAO;

    public IApplicationDAO getApplicationDAO() {
        return applicationDAO;
    }

    public void setApplicationDAO(IApplicationDAO applicationDAO) {
        this.applicationDAO = applicationDAO;
    }

    public void create(Application application) {
        applicationDAO.create(application);
    }

    public void update(Application application) {
        applicationDAO.update(application);
    }

    public Application getById(Long applicationId) {
        return applicationDAO.getById(applicationId);
    }

    public List<Application> getAll() {
        return applicationDAO.getAll();
    }

    public Application getByName(String applicationName) {
        return applicationDAO.getByName(applicationName);
    }

    public void delete(Application application) {
        applicationDAO.delete(application);
    }
}
