package caseModule.service.classImplement;

import caseModule.model.Customer;
import caseModule.service.interfacee.CustomerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    public CustomerServiceImpl() {
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/case_module3?useSSL=false", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Customer> printAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("Select * from customer")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String numberPhone = rs.getString("numberPhone");
                String email = rs.getString("email");
                String userNameAcc = rs.getString("userNameAcc");
                String pass = rs.getString("pass");
                int role = rs.getInt("role");
                double money = rs.getDouble("money");
                customers.add(new Customer(id, name, age, numberPhone, email,money, userNameAcc, pass, role));
            }
        } catch (SQLException e) {
        }
        return customers;
    }

    @Override
    public List<Customer> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findByName(String key) throws SQLException {
        List<Customer> customer = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("Select * from customer where name like ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%" + key + "%");
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String numberPhone = rs.getString("numberPhone");
                String email = rs.getString("email");
                double money = rs.getDouble("money");
                String userNameAcc = rs.getString("userNameAcc");
                String pass = rs.getString("pass");
                int role = rs.getInt("role");
                customer.add(new Customer(id, name, age, numberPhone, email,money, userNameAcc, pass, role));
            }
        } catch (SQLException e) {
        }
        return customer;
    }

    @Override
    public void add(Customer customer) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(name,age,numberPhone,email,money,userNameAcc,pass) value  (?,?,?,?,?,?,?)")) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(2, customer.getAge());
            preparedStatement.setString(3, customer.getNumberPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setDouble(5, customer.getMoney());
            preparedStatement.setString(6, customer.getUserNameAcc());
            preparedStatement.setString(7, customer.getPass());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void edit(int id, Customer customer) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update customer set name=?,age=?,numberPhone=?,email=?,money=?,userNameAcc=?,pass=?  where id=?")) {
            preparedStatement.setInt(8,id);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(2, customer.getAge());
            preparedStatement.setString(3, customer.getNumberPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setDouble(5, customer.getMoney());
            preparedStatement.setString(6, customer.getUserNameAcc());
            preparedStatement.setString(7, customer.getPass());
            preparedStatement.executeUpdate();
        }
    }


    @Override
    public Customer delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update customer set role=2  where id=?")) {
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
        }
        return null;
    }
    @Override
    public Customer findById(int key) throws SQLException {
        Customer customer = new Customer();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("Select * from customer where id = ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, key);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String numberPhone = rs.getString("numberPhone");
                String email = rs.getString("email");
                double money = rs.getDouble("money");
                String userNameAcc = rs.getString("userNameAcc");
                String pass = rs.getString("pass");
                int role = rs.getInt("role");
                customer = new Customer(id, name, age, numberPhone, email,money, userNameAcc, pass, role);
            }
        } catch (SQLException e) {
        }
        return customer;
    }

    @Override
    public void delete(int id, Customer customer) throws SQLException {

    }
}
