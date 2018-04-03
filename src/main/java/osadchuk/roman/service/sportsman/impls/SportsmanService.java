package osadchuk.roman.service.sportsman.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportsman.impls.SportsmanDAOFakeImpl;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.service.sportsman.interfaces.ISportsmanService;

import java.util.List;

@Service
public class SportsmanService implements ISportsmanService {
    @Autowired
    SportsmanDAOFakeImpl sportsmanDAO;

    @Override
    public Sportsman insertSportsman(Sportsman sportsman) {
        return sportsmanDAO.insertSportsman(sportsman);
    }

    @Override
    public Sportsman getSportsman(int id) {
        return sportsmanDAO.getSportsman(id);
    }

    @Override
    public Sportsman updateSportsman(Sportsman sportsman) {
        return sportsmanDAO.updateSportsman(sportsman);
    }

    @Override
    public Sportsman deleteSportsman(int id) {
        return sportsmanDAO.deleteSportsman(id);
    }

    @Override
    public List<Sportsman> getAll() {
        return sportsmanDAO.getAll();
    }
}
