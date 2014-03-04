package ru.geminisystems.dao;

import java.util.List;

import ru.geminisystems.entity.Order;

public interface IOrderDAO {

    //void create(Order order);
    
    void update(Order order);

    Order getById(Long orderId);

    List<Order> getAll();

    void delete(Order order);
}
