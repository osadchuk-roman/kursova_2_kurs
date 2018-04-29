package osadchuk.roman.DAO.sportArena.interfaces;

import osadchuk.roman.model.SportArena;

import java.sql.SQLException;
import java.util.List;

public interface ISportArenaDAO {
    public SportArena insertSportArena(SportArena sportArena) throws SQLException;
    public SportArena getSportArena(int id) throws SQLException;
    public SportArena updateSportArena(SportArena sportArena) throws SQLException;
    public SportArena deleteSportArena(int id) throws SQLException;
    public List<SportArena> getAll() throws SQLException;
}
