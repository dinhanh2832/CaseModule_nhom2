package caseModule.service.classImplement;

import caseModule.model.ClassifyProduct;
import caseModule.service.interfacee.ClassifyProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassifyProductServiceImpl implements ClassifyProductService {
    public ClassifyProductServiceImpl() {
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
    public List<ClassifyProduct> printAll() throws SQLException {
        return null;
    }

    @Override
    public List<ClassifyProduct> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<ClassifyProduct> findByName(String key) throws SQLException {
        List<ClassifyProduct> classifyProducts = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("Select * from classifyproduct where category like ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%" + key + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String category = rs.getString("category");
                classifyProducts.add(new ClassifyProduct(id, category));
            }
        } catch (SQLException e) {
        }
        return classifyProducts;
    }

    @Override
    public void add(ClassifyProduct classifyProduct) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into classifyproduct (id,ClassifyProduct) value  (?,?)");) {
            preparedStatement.setInt(1, classifyProduct.getId());
            preparedStatement.setString(2, classifyProduct.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void edit(int id, ClassifyProduct classifyProduct) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update classifyproduct set id=?,category=?  where id=?")) {
            preparedStatement.setInt(1, classifyProduct.getId());
            preparedStatement.setString(2, classifyProduct.getCategory());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from classifycroduct where id = ?");) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public ClassifyProduct findById(int key) throws SQLException {
        ClassifyProduct classifyProduct = new ClassifyProduct();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("Select * from classifyproduct where id = ?");) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, key);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String category = rs.getString("category");
                classifyProduct = new ClassifyProduct(id, category);
            }
        } catch (SQLException e) {
        }
        return classifyProduct;
    }
}
