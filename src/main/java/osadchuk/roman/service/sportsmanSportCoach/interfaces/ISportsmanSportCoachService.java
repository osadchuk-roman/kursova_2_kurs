package osadchuk.roman.service.sportsmanSportCoach.interfaces;

import osadchuk.roman.model.SportsmanSportCoach;

import java.sql.SQLException;
import java.util.List;

public interface ISportsmanSportCoachService {
    public SportsmanSportCoach insertSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) throws SQLException;
    public SportsmanSportCoach getSportsmanSportCoach(int id) throws SQLException;
    public SportsmanSportCoach updateSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) throws SQLException;
    public SportsmanSportCoach deleteSportsmanSportCoach(int id) throws SQLException;
    public List<SportsmanSportCoach> getAll() throws SQLException;
}
