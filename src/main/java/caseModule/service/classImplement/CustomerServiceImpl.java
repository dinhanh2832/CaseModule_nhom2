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
                int numberPhone = rs.getInt("numberPhone");
                String email = rs.getString("email");
                double money = rs.getDouble("money");
                String userNameAcc = rs.getString("userNameAcc");
                String pass = rs.getString("pass");
                int role = rs.getInt("role");
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
                int numberPhone = rs.getInt("numberPhone");
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
             PreparedStatement preparedStatement = connection.prepareStatement("insert into customer(id,name,age,numberPhone,email,userNameAcc,pass,role) value  (?,?,?,?,?,?,?,?)");) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getAge());
            preparedStatement.setInt(4, customer.getNumberPhone());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setDouble(6, customer.getMoney());
            preparedStatement.setString(7, customer.getUserNameAcc());
            preparedStatement.setString(8, customer.getPass());
            preparedStatement.setInt(9, customer.getRole());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void edit(int id, Customer customer) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update customer set id=?,name=?,age=?,numberPhone=?,email=?,userNameAcc=?,pass=?,role=?  where id=?")) {
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getAge());
            preparedStatement.setInt(4, customer.getNumberPhone());
            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setString(6, customer.getUserNameAcc());
            preparedStatement.setString(7, customer.getPass());
            preparedStatement.setInt(8, customer.getRole());
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from customer where id = ?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
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
                int numberPhone = rs.getInt("numberPhone");
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
}
