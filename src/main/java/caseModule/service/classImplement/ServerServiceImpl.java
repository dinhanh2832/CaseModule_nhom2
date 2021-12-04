package caseModule.service.classImplement;

import caseModule.model.Server;
import caseModule.service.interfacee.ServerService;

import java.sql.SQLException;
import java.util.List;

public class ServerServiceImpl implements ServerService<Server> {
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
