package caseModule.service.classImplement;

import caseModule.model.ClassifyProduct;
import caseModule.service.interfacee.ClassifyProductService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ClassifyProductServiceImpl implements ClassifyProductService {
    public ClassifyProductServiceImpl() {
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
    public List<ClassifyProduct> printAll() throws SQLException {
        return null;
    }

    @Override
    public List<ClassifyProduct> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<ClassifyProduct> findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void add(ClassifyProduct classifyProduct) throws SQLException {

    }

    @Override
    public void edit(int id,ClassifyProduct classifyProduct) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public ClassifyProduct findById(int id) throws SQLException {
        return null;
    }
}
