package caseModule.service.interfacee;

import caseModule.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService extends Service<Product> {
    List<Product> findByName(int key) throws SQLException;
}
