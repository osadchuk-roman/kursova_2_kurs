package osadchuk.roman.service.sportsmanSportCoach.interfaces;

import osadchuk.roman.model.SportsmanSportCoach;

import java.util.List;

public interface ISportsmanSportCoachService {
    public SportsmanSportCoach insertSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach);
    public SportsmanSportCoach getSportsmanSportCoach(int id);
    public SportsmanSportCoach updateSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach);
    public SportsmanSportCoach deleteSportsmanSportCoach(int id);
    public List<SportsmanSportCoach> getAll();
}
