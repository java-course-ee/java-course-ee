package ru.geminisystems.dao.impl;


import org.springframework.orm.hibernate3.HibernateTemplate;
import ru.geminisystems.dao.IApplicationDAO;
import ru.geminisystems.entity.Application;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 14.07.2009
 * Time: 14:52:58
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationDAOImpl implements IApplicationDAO {


    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void create(Application application) {
        template.save(application);
    }

    public void update(Application application) {
        template.saveOrUpdate(application);
    }

    public Application getById(Long applicationId) {
        return (Application) template.get(Application.class, applicationId);
    }

    public List<Application> getAll() {
        //noinspection JpaQlInspection
        return template.find("from Application order by applicationName");
    }

    public Application getByName(String applicationName) {
        //noinspection JpaQlInspection
        return (Application) (template.find("from Application a where a.applicationName = ?", applicationName).get(0));
    }

    public void delete(Application application) {
        template.delete(application);
        template.flush();
    }
}
