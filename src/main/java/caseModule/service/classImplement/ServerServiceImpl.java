package caseModule.service.classImplement;

import caseModule.model.Server;
import caseModule.service.interfacee.ServerService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public List<Server> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<Server> findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void add(Server server) throws SQLException {

    }

    @Override
    public void edit(Server server) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public Server findById(int id) throws SQLException {
        return null;
    }
}
