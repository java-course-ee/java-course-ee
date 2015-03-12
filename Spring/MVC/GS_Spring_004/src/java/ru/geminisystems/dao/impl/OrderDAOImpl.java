package ru.geminisystems.dao.impl;


import org.springframework.orm.hibernate3.HibernateTemplate;
import ru.geminisystems.dao.IOrderDAO;
import ru.geminisystems.entity.Order;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: gb
 * Date: 14.07.2009
 * Time: 16:10:03
 * To change this template use File | Settings | File Templates.
 */
public class OrderDAOImpl implements IOrderDAO {

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    //public void create(Order order) {
    //template.save(order);
    //}

    public void update(Order order) {
        template.saveOrUpdate(order);
    }

    public Order getById(Long orderId) {
        return (Order) template.get(Order.class, orderId);
    }

    public List<Order> getAll() {
        //noinspection JpaQlInspection
        return template.find("from Order order by startDate");
    }

    public void delete(Order order) {
        template.delete(order);
    }


}
