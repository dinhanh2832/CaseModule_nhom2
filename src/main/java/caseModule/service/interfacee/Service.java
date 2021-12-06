package caseModule.service.interfacee;

import caseModule.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface Service <T>{
    List<T> printAll() throws SQLException;
    List<T> printAllOrderByPrice() throws SQLException;
    List<T> findByName(String name) throws SQLException;
    void add(T t) throws SQLException;
    void edit(int id,T t) throws SQLException;
    Customer delete(int id) throws SQLException;
    T findById(int id) throws SQLException;
}
