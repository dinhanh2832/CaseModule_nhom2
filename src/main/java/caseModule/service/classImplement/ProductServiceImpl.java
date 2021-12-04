package caseModule.service.classImplement;

import caseModule.model.Product;
import caseModule.service.interfacee.ProductService;

import java.sql.*;
import java.util.ArrayList;
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
        List<Product> productList=new ArrayList<>();
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select *from product");
        ResultSet rs= preparedStatement.executeQuery();
        while (rs.next()){
            int id=rs.getInt("id");
            int price= rs.getInt("price");
            int classifyId=rs.getInt("classifyId");
            String description=rs.getString("description");
            String userProduct=rs.getString("userProduct");
            String pass=rs.getString("pass");
            int status=rs.getInt("status");
            int severId=rs.getInt("serverId");
            productList.add(new Product(id,price,classifyId,description,userProduct,pass,status,severId));
        }
        return productList;
    }

    @Override
    public List<Product> printAllOrderByPrice() throws SQLException {
        List<Product> productList=new ArrayList<>();
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select *from product order by price desc ");
        ResultSet rs= preparedStatement.executeQuery();
        while (rs.next()){
            int id=rs.getInt("id");
            int price= rs.getInt("price");
            int classifyId=rs.getInt("classifyId");
            String description=rs.getString("description");
            String userProduct=rs.getString("userProduct");
            String pass=rs.getString("pass");
            int status=rs.getInt("status");
            int severId=rs.getInt("serverId");
            productList.add(new Product(id,price,classifyId,description,userProduct,pass,status,severId));
        }
        return productList;
    }

    @Override
    public List<Product> findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void add(Product product) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into product(id,price,classifyId,description,userProduct,pass,status,serverId) value (?,?,?,?,?,?,?,?)");
       preparedStatement.setInt(1,product.getId());
       preparedStatement.setInt(2,product.getPrice());
       preparedStatement.setInt(3,product.getClassifyId());
       preparedStatement.setString(4,product.getDescription());
       preparedStatement.setString(5,product.getUserProduct());
       preparedStatement.setString(6,product.getPass());
       preparedStatement.setInt(7,product.getStatus());
       preparedStatement.setInt(8,product.getServerId());
        preparedStatement.executeUpdate();

    }

    @Override
    public void edit(int id,Product product) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("update product set id=?,price=?,classifyId=?,description=?,userProduct=?,pass=?,status=?,serverId=? where id=?");
        preparedStatement.setInt(1,product.getId());
        preparedStatement.setInt(2,product.getPrice());
        preparedStatement.setInt(3,product.getClassifyId());
        preparedStatement.setString(4,product.getDescription());
        preparedStatement.setString(5,product.getUserProduct());
        preparedStatement.setString(6,product.getPass());
        preparedStatement.setInt(7,product.getStatus());
        preparedStatement.setInt(8,product.getServerId());
        preparedStatement.setInt(9,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("delete from product where id=?");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();

    }

    @Override
    public Product findById(int id) throws SQLException {
        Product product=null;
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select *from product where id=?");
        preparedStatement.setInt(1,id);
        ResultSet rs=preparedStatement.executeQuery();
        while (rs.next()){
            int id1=rs.getInt("id");
            int price= rs.getInt("price");
            int classifyId=rs.getInt("classifyId");
            String description=rs.getString("description");
            String userProduct=rs.getString("userProduct");
            String pass=rs.getString("pass");
            int status=rs.getInt("status");
            int severId=rs.getInt("serverId");
            product=new Product(id1,price,classifyId,description,userProduct,pass,status,severId);
        }
        return product;
    }
}
