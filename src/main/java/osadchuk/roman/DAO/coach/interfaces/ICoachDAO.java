package osadchuk.roman.DAO.coach.interfaces;

import osadchuk.roman.model.Coach;

import java.sql.SQLException;
import java.util.List;

public interface ICoachDAO {
    public Coach insertCoach(Coach coach) throws SQLException;
    public Coach getCoach(int id) throws SQLException;
    public Coach updateCoach(Coach coach) throws SQLException;
    public Coach deleteCoach(int id) throws SQLException;
    public List<Coach> getAll() throws SQLException;
}
