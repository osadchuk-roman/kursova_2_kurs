package osadchuk.roman.DAO.court.interfaces;

import osadchuk.roman.model.Court;

import java.sql.SQLException;
import java.util.List;

public interface ICourtDAO {
    public Court insertCourt(Court court) throws SQLException;
    public Court getCourt(int id) throws SQLException;
    public Court updateCourt(Court court) throws SQLException;
    public Court deleteCourt(int id) throws SQLException;
    public List<Court> getAll() throws SQLException;
}
