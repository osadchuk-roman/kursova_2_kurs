package osadchuk.roman.DAO.sportsmanCompetition.interfaces;

import osadchuk.roman.model.SportsmanCompetition;

import java.sql.SQLException;
import java.util.List;

public interface ISportsmanCompetitionDAO {
    public SportsmanCompetition insertSportsmanCompetition(SportsmanCompetition sportsmanCompetition) throws SQLException;
    public SportsmanCompetition getSportsmanCompetition(int id) throws SQLException;
    public SportsmanCompetition updateSportsmanCompetition(SportsmanCompetition sportsmanCompetition) throws SQLException;
    public SportsmanCompetition deleteSportsmanCompetition(int id) throws SQLException;
    public List<SportsmanCompetition> getAll() throws SQLException;
}
