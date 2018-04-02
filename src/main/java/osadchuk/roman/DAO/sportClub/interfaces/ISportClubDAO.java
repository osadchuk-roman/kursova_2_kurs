package osadchuk.roman.DAO.sportClub.interfaces;

import osadchuk.roman.model.SportClub;

import java.util.List;

public interface ISportClubDAO {
    public SportClub insertSportClub(SportClub sportClub);
    public SportClub getSportClub(int id);
    public SportClub updateSportClub(SportClub sportClub);
    public SportClub deleteSportClub(int id);
    public List<SportClub> getAll();
}
