package osadchuk.roman.service.sportClub.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportClub.impls.SportClubDAOFakeImpl;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.service.sportClub.interfaces.ISportClubService;

import java.util.List;

@Service
public class SportClubService implements ISportClubService {
    @Autowired
    SportClubDAOFakeImpl sportClubDAO;

    @Override
    public SportClub insertSportClub(SportClub sportClub) {
        return sportClubDAO.insertSportClub(sportClub);
    }

    @Override
    public SportClub getSportClub(int id) {
        return sportClubDAO.getSportClub(id);
    }

    @Override
    public SportClub updateSportClub(SportClub sportClub) {
        return sportClubDAO.updateSportClub(sportClub);
    }

    @Override
    public SportClub deleteSportClub(int id) {
        return sportClubDAO.deleteSportClub(id);
    }

    @Override
    public List<SportClub> getAll() {
        return sportClubDAO.getAll();
    }
}
