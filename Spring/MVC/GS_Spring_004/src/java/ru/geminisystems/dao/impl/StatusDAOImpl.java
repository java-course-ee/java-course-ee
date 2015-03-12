package ru.geminisystems.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;
import ru.geminisystems.dao.IStatusDAO;
import ru.geminisystems.entity.Status;

import java.util.List;

public class StatusDAOImpl implements IStatusDAO {

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public void create(Status status) {
        template.save(status);
    }

    public void delete(Status status) {
        template.delete(status);

    }

    public List<Status> getAll() {
        //noinspection JpaQlInspection
        return template.find("FROM Status order by statusName");
    }

    public Status getById(Long statusId) {
        return (Status) template.load(Status.class, statusId);
    }

    public Status getByName(String statusName) {
        //noinspection JpaQlInspection
        return (Status) template.find("FROM Status s where s.statusName = ?", statusName).get(0);
    }

    public void update(Status status) {
        template.saveOrUpdate(status);

    }

    public List<Status> getOrderStatuces() {
        //noinspection JpaQlInspection
        return template.find("from Status s where s.statusName in ('submitted', 'in_progress', 'approved', 'declined') ");
    }
}
