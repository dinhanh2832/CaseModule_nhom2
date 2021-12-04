package caseModule.service.classImplement;

import caseModule.model.Customer;
import caseModule.service.interfacee.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
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
