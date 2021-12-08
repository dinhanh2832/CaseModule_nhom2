package caseModule.service.classImplement;

import caseModule.model.Customer;
import caseModule.model.Order;
import caseModule.service.interfacee.OrderService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    public OrderServiceImpl() {
    }

    private Connection getConnection(){
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

        List<Order> orders = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select *from orders");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id=rs.getInt("id");
            String time=rs.getString("time");
            int customerId=rs.getInt("customerId");
            int productId=rs.getInt("productId");
            orders.add(new Order(id,time,customerId,productId));
        }
        return orders;
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
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("insert into orders (time,customerId,productId) values (?,?,?,?)")) {
            preparedStatement.setString(1,order.getTime());
            preparedStatement.setInt(2,order.getCustomerId());
            preparedStatement.setInt(3,order.getProductId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(int id,Order order) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update orders set id=?,time=?,customerId=?,productId=?  where id=?")) {
       preparedStatement.setInt(1, order.getId());
       preparedStatement.setString(2, order.getTime());
       preparedStatement.setInt(3, order.getCustomerId());
       preparedStatement.setInt(4, order.getProductId());
       preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from orders where id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Order findById(int id) throws SQLException {
        Order order = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select  *from orders where id=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id1 = rs.getInt("id");
            String time = rs.getString("time");
            int customerId=rs.getInt("customerId");
            int productId=rs.getInt("productId");
            order=new Order(id1,time,customerId,productId);
        }

        return order;
    }

    @Override
    public void editMoneyOfCustomer(int id, int money) {

    }
}
