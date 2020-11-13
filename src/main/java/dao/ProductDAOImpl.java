package dao;

import model.Categori;
import model.Product;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/linkkool?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Vuoncodai123";

    private static final String SEARCH_PRODUCT_SQL =  "select * from linkkool.product where name like concat('%',?,'%');";
    private static final String DELETE_PRODUCT_SQL = " DELETE FROM linkkool.product WHERE id = ?;";
    private static final String SELECT_ALL_PRODUCT_SQL = "select * from linkkool.product;";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE linkkool.product SET id_categori = ?, name = ?, amount = ?, size = ?, price = ? WHERE id = ?;";
    private static final String SELECT_PRODUCT_BY_ID = "select * from linkkool.product where id =  ?; ";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product"
            + " (id, id_categori, name, amount, size, price) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

    ICategoriDAO icategoriDAO = new CategoriDAOImpl();

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> listProduct() {
        ICategoriDAO iCategoriDAO = new CategoriDAOImpl();
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCT_SQL)) {
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                int idCategori = rs.getInt("id_categori");
                String nameProduct = rs.getString("name");
                int amount = rs.getInt("amount");
                String size = rs.getString("size");
                double price = rs.getDouble("price");
                Categori categori = iCategoriDAO.getCategoriByID(idCategori);
                productList.add(new Product(idProduct,categori,nameProduct,amount,size,price));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
                return productList;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            ps.setInt(1, product.getId());
            ps.setInt(2, product.getCategori().getId());
            ps.setString(3, product.getName());
            ps.setInt(4, product.getAmount());
            ps.setString(5, product.getSize());
            ps.setDouble(6, product.getPrice());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public String getNameProductByID(int id) {
        return null;
    }

    @Override
    public List<Product> searchProduct(String name) throws SQLException {
        List<Product> productList = new ArrayList<>();
        ICategoriDAO iCategoriDAO = new CategoriDAOImpl();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_SQL);) {
            preparedStatement.setString(1,name);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                int idCateGory = rs.getInt("id_categori");
                String nameProduct = rs.getString("name");
                int amountProduct = rs.getInt("amount");
                String sizeProduct = rs.getString("size");
                double priceProduct = rs.getDouble("price");

                Categori categori = iCategoriDAO.getCategoriByID(idCateGory);
                productList.add(new Product(idProduct,categori,nameProduct,amountProduct,sizeProduct,priceProduct));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }

    @Override
    public Product getProductByID(int id) {
        Product product = new Product();
        Categori categori;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setInt(1,id);

            ResultSet rs =preparedStatement.executeQuery();

            while (rs.next()) {
                int idProduct = rs.getInt("id");
                int idCategori = rs.getInt("id_categori");
                String nameProduct = rs.getString("name");
                int amountProduct = rs.getInt("amount");
                String sizeProduct = rs.getString("size");
                double priceProduct = rs.getDouble("price");
                categori = icategoriDAO.getCategoriByID(idCategori);
                product =new Product(idProduct,categori,nameProduct,amountProduct,sizeProduct,priceProduct);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean update(Product product) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {

            statement.setInt(1, product.getCategori().getId());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getAmount());
            statement.setString(4, product.getSize());
            statement.setDouble(5,product.getPrice());
            statement.setInt(6,product.getId());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException, ServletException, IOException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            System.out.println(statement);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
