package osadchuk.roman.service.sportsmanCompetition;

import osadchuk.roman.model.SportsmanCompetition;

import java.util.List;

public interface ISportsmanCompetitionService {
    public SportsmanCompetition insertSportsmanCompetition(SportsmanCompetition sportsmanCompetition);
    public SportsmanCompetition getSportsmanCompetition(int id);
    public SportsmanCompetition updateSportsmanCompetition(SportsmanCompetition sportsmanCompetition);
    public SportsmanCompetition deleteSportsmanCompetition(int id);
    public List<SportsmanCompetition> getAll();
}
