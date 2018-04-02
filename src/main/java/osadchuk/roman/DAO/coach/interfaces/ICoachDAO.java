package osadchuk.roman.DAO.coach.interfaces;

import osadchuk.roman.model.Coach;

import java.util.List;

public interface ICoachDAO {
    public Coach insertCoach(Coach coach);
    public Coach getCoach(int id);
    public Coach updateCoach(Coach coach);
    public Coach deleteCoach(int id);
    public List<Coach> getAll();
}
