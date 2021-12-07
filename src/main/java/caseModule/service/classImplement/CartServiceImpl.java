package caseModule.service.classImplement;

import caseModule.model.Cart;
import caseModule.model.Order;
import caseModule.service.interfacee.CartService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    public CartServiceImpl() {
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
    public List<Cart> printAll() throws SQLException {
        List<Cart> carts = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select idProduct,idCustomer from cart");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int customerId=rs.getInt("idCustomer");
            int productId=rs.getInt("idProduct");
            carts.add(new Cart(productId,customerId));
        }
        return carts;
    }

    @Override
    public List<Cart> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<Cart> findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void add(Cart cart) throws SQLException {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("insert into cart (idProduct,idCustomer) values (?,?)")) {
            preparedStatement.setInt(1,cart.getIdProduct());
            preparedStatement.setInt(2,cart.getIdCustomer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(int id, Cart cart) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from cart where idProduct=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Cart findById(int id) throws SQLException {

       Cart cart=null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select  *from cart where id=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {

            int customerId=rs.getInt("idCustomer");
            int productId=rs.getInt("idProduct");
            cart=new Cart(productId,customerId);
        }


        return cart;
    }
}
