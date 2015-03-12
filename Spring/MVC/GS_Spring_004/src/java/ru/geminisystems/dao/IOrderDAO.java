package ru.geminisystems.dao;

import ru.geminisystems.entity.Order;

import java.util.List;

public interface IOrderDAO {

    //void create(Order order);

    void update(Order order);

    Order getById(Long orderId);

    List<Order> getAll();

    void delete(Order order);
}
