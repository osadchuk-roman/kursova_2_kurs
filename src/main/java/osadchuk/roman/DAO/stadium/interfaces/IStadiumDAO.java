package osadchuk.roman.DAO.stadium.interfaces;

import osadchuk.roman.model.Stadium;

import java.sql.SQLException;
import java.util.List;

public interface IStadiumDAO {
    public Stadium insertStadium(Stadium stadium) throws SQLException;
    public Stadium getStadium(int id) throws SQLException;
    public Stadium updateStadium(Stadium stadium) throws SQLException;
    public Stadium deleteStadium(int id) throws SQLException;
    public List<Stadium> getAll() throws SQLException;
}
