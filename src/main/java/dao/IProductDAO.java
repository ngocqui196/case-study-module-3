package dao;

import model.Product;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> listProduct();
    public void insertProduct(Product product) throws SQLException;
    String getNameProductByID(int id);
    public List<Product> searchProduct(String name) throws SQLException;
    Product getProductByID(int id);
    boolean update(Product product);
    boolean delete(int id) throws SQLException, ServletException, IOException;
}
