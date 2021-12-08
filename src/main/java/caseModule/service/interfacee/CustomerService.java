package caseModule.service.interfacee;

import caseModule.model.Customer;

import java.sql.SQLException;

public interface CustomerService extends Service<Customer>{
    void delete(int id, Customer customer) throws SQLException;
    void editA(int id, Customer customer)throws SQLException;
}
