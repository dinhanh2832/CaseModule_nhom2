package caseModule.service.classImplement;

import caseModule.model.Customer;
import caseModule.service.interfacee.CustomerService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    public CustomerServiceImpl() {
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
    public List<Customer> printAll() throws SQLException {
        return null;
    }

    @Override
    public List<Customer> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void add(Customer customer) throws SQLException {

    }

    @Override
    public void edit(Customer customer) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Customer findById(int id) throws SQLException {
        return null;
    }
}
