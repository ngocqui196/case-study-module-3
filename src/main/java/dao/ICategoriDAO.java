package dao;

import model.Categori;

import java.sql.SQLException;
import java.util.List;

public interface ICategoriDAO {
List<Categori> listCategori();
Categori getCategoriByID(int id);
Categori getCategoriByName(String categoriName);
void save(Categori categori);
boolean update(Categori categori);
boolean delete(int id) throws SQLException;

}
