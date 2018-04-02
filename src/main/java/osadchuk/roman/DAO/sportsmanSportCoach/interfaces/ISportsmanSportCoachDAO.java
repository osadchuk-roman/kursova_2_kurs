package osadchuk.roman.DAO.sportsmanSportCoach.interfaces;

import osadchuk.roman.model.SportsmanSportCoach;

import java.util.List;

public interface ISportsmanSportCoachDAO {
    public SportsmanSportCoach insertSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach);
    public SportsmanSportCoach getSportsmanSportCoach(int id);
    public SportsmanSportCoach updateSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach);
    public SportsmanSportCoach deleteSportsmanSportCoach(int id);
    public List<SportsmanSportCoach> getAll();
}
