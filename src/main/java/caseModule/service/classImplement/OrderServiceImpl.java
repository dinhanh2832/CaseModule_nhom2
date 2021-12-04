package caseModule.service.classImplement;

import caseModule.model.Order;
import caseModule.service.interfacee.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> printAll() throws SQLException {
        return null;
    }

    @Override
    public List<Order> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<Order> findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void add(Order order) throws SQLException {

    }

    @Override
    public void edit(Order order) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Order findById(int id) throws SQLException {
        return null;
    }
}
