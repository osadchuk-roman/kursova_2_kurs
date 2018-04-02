package osadchuk.roman.DAO.competition.interfaces;

import osadchuk.roman.model.Competition;

import java.util.List;

public interface ICompetitionDAO {
    public Competition insertCompetition(Competition competition);
    public Competition getCompetition(int id);
    public Competition updateCompetition(Competition competition);
    public Competition deleteCompetition(int id);
    public List<Competition> getAll();
}
