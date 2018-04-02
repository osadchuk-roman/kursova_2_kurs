package osadchuk.roman.service.sportClub.interfaces;

import osadchuk.roman.model.SportClub;

import java.util.List;

public interface ISportClubService {
    public SportClub insertSportClub(SportClub sportClub);
    public SportClub getSportClub(int id);
    public SportClub updateSportClub(SportClub sportClub);
    public SportClub deleteSportClub(int id);
    public List<SportClub> getAll();
}
