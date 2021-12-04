package caseModule.service.classImplement;

import caseModule.model.Product;
import caseModule.service.interfacee.ProductService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    public ProductServiceImpl() {
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
    public List<Product> printAll() throws SQLException {
        return null;
    }

    @Override
    public List<Product> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<Product> findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void add(Product product) throws SQLException {

    }

    @Override
    public void edit(Product product) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Product findById(int id) throws SQLException {
        return null;
    }
}
