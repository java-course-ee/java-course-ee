package ru.geminisystems.dao.service;


import ru.geminisystems.dao.IOrderDAO;
import ru.geminisystems.entity.Order;

import java.util.List;


public class OrderService {

    private IOrderDAO orderDAO;

    public IOrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    //public void create(Order order) {
    //orderDAO.create(order);
    //}

    public void update(Order order) {
        orderDAO.update(order);
    }

    public Order getById(Long orderId) {
        return orderDAO.getById(orderId);
    }

    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    public void delete(Order order) {
        orderDAO.delete(order);
    }


}
