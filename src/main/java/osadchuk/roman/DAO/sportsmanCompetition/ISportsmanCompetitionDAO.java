package osadchuk.roman.DAO.sportsmanCompetition;

import osadchuk.roman.model.SportsmanCompetition;

import java.util.List;

public interface ISportsmanCompetitionDAO {
    public SportsmanCompetition insertSportsmanCompetition(SportsmanCompetition sportsmanCompetition);
    public SportsmanCompetition getSportsmanCompetition(int id);
    public SportsmanCompetition updateSportsmanCompetition(SportsmanCompetition sportsmanCompetition);
    public SportsmanCompetition deleteSportsmanCompetition(int id);
    public List<SportsmanCompetition> getAll();
}
