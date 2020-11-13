package dao;

import model.Categori;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriDAOImpl implements ICategoriDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/linkkool?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Vuoncodai123";

    private static final String SELECT_CATEGORI_BY_ID = "select * from linkkool.categori WHERE id_categori = ?;";
    private static final String SELECT_CATEGORI_BY_NAME = "select * from linkkool.categori WHERE name_categori = ?;";
    private static final String SELECT_ALL_CATEGORI = "select * from linkkool.categori;";
    private static  final String ADD_CATEGORI = "insert into linkkool.categori values (?,?);";
    private static final String UPDATE_CATEGORI_SQL = "UPDATE linkkool.categori SET name_categori = ? WHERE (id_categori = ?);";
    private static final String DELETE_USERS_SQL = "delete from categori where id_categori = ?;";

    public CategoriDAOImpl() {
    }

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
    public List<Categori> listCategori() {
        List<Categori> categoriList = new ArrayList<>();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORI)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idCategori = rs.getInt("id_categori");
                String nameCategori = rs.getString("name_categori");
                categoriList.add(new Categori(idCategori,nameCategori));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoriList;
    }

    @Override
    public Categori getCategoriByID(int id) {
        Categori categori = null;
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORI_BY_ID)) {
            preparedStatement.setInt(1,id);

            ResultSet rs =preparedStatement.executeQuery();

            while (rs.next()) {
                int idCategoti = rs.getInt("id_categori");
                String nameCategoti = rs.getString("name_categori");

                categori =new Categori(idCategoti,nameCategoti);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categori;
    }

    @Override
    public Categori getCategoriByName(String name) {
        Categori categori = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORI_BY_NAME)) {
            preparedStatement.setString(1,name);

            ResultSet rs =preparedStatement.executeQuery();

            while (rs.next()) {
                int idCategoti = rs.getInt("id_categori");
                String nameCategoti = rs.getString("name_categori");

                categori =new Categori(idCategoti,nameCategoti);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categori;
    }

    @Override
    public void save(Categori categori) {
        System.out.println(ADD_CATEGORI);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(ADD_CATEGORI)) {
            ps.setInt(1, categori.getId());
            ps.setString(2, categori.getName());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean update( Categori categori) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORI_SQL)) {

            statement.setString(1, categori.getName());
            statement.setInt(2, categori.getId());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
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
