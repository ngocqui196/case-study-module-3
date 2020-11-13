package dao;

import model.Login;

import java.sql.SQLException;

public interface ILoginDAO {
   public Login checkLogin(String acc, String pass) throws SQLException;

    public Login insertLogin(Login login) throws SQLException;

}
