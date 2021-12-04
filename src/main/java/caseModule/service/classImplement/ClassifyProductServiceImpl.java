package caseModule.service.classImplement;

import caseModule.model.ClassifyProduct;
import caseModule.service.interfacee.ClassifyProductService;

import java.sql.SQLException;
import java.util.List;

public class ClassifyProductServiceImpl implements ClassifyProductService {
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
    public void edit(ClassifyProduct classifyProduct) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public ClassifyProduct findById(int id) throws SQLException {
        return null;
    }
}
