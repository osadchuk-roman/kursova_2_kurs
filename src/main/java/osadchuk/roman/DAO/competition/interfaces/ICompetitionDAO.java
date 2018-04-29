package osadchuk.roman.DAO.competition.interfaces;

import osadchuk.roman.model.Competition;

import java.sql.SQLException;
import java.util.List;

public interface ICompetitionDAO {
    public Competition insertCompetition(Competition competition) throws SQLException;
    public Competition getCompetition(int id) throws SQLException;
    public Competition updateCompetition(Competition competition) throws SQLException;
    public Competition deleteCompetition(int id) throws SQLException;
    public List<Competition> getAll() throws SQLException;
}
