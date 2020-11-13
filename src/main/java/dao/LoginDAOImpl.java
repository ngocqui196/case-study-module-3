package dao;

import model.Login;

import java.sql.*;

public class LoginDAOImpl implements ILoginDAO{
    private static final String CHECK_ACC_LOGIN = "select * from login where account = ? and password = ?";

    private String jdbcURL = "jdbc:mysql://localhost:3306/linkkool?useSSL=false";
    private String jdbcUsername ="root";
    private String jdbcPassword = "Vuoncodai123";
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
    public Login checkLogin(String acc,String pass) throws SQLException {
            Login login = null;
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ACC_LOGIN)){
                preparedStatement.setString(1,acc);
                preparedStatement.setString(2,pass);
                System.out.println(preparedStatement);
                ResultSet rs =preparedStatement.executeQuery();

                while (rs.next()){
                    String account =rs.getString("account");
                    String password =rs.getString("password");
                    login =new Login(account,password);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return login;
    }

    @Override
    public Login insertLogin(Login login) throws SQLException {
        return null;
    }
}
