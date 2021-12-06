package caseModule.service.classImplement;

import caseModule.model.Customer;
import caseModule.model.Server;
import caseModule.service.interfacee.ServerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServerServiceImpl implements ServerService {
    public ServerServiceImpl() {
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
    public List<Server> printAll() throws SQLException {
        List<Server> servers = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select *from server");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id=rs.getInt("id");
            String name=rs.getString("name");
            servers.add(new Server(id,name));

        }
        return servers;
    }

    @Override
    public List<Server> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<Server> findByName(String name) throws SQLException {
        List<Server> servers = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select  *from server where name like ? ");
        preparedStatement.setString(1, '%'+name+'%');
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name1 = resultSet.getString("name");
            servers.add(new Server(id,name1));
        }
        return servers;
    }

    @Override
    public void add(Server server) throws SQLException {

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("insert into server (id,name) values (?,?)")) {
            preparedStatement.setInt(1, server.getId());
            preparedStatement.setString(2, server.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(int id,Server server) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update server set id=? ,name=? where id=?")) {

            preparedStatement.setInt(1, server.getId());
            preparedStatement.setString(2, server.getName());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from server where id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public Server findById(int id) throws SQLException {

        Server server= null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select  *from server where id=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id1 = rs.getInt("id");
            String name = rs.getString("name");
            server=new Server(id1,name);
        }

        return server;
    }
}
