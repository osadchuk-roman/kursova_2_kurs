package osadchuk.roman.DAO.sportsman.interfaces;

import osadchuk.roman.model.Sportsman;

import java.sql.SQLException;
import java.util.List;

public interface ISportsmanDAO {
    public Sportsman insertSportsman(Sportsman sportsman) throws SQLException;
    public Sportsman getSportsman(int id) throws SQLException;
    public Sportsman updateSportsman(Sportsman sportsman) throws SQLException;
    public Sportsman deleteSportsman(int id) throws SQLException;
    public List<Sportsman> getAll() throws SQLException;
}
