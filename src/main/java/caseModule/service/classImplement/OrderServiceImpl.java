package caseModule.service.classImplement;

import caseModule.model.Order;
import caseModule.service.interfacee.OrderService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    public OrderServiceImpl() {
    }

    protected Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/case_module3?useSSL=false", "root", "123456");
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
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
