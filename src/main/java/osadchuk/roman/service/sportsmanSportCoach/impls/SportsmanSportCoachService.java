package osadchuk.roman.service.sportsmanSportCoach.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportsmanSportCoach.impls.SportsmanSportCoachDAOFakeImpl;
import osadchuk.roman.model.SportsmanSportCoach;
import osadchuk.roman.service.sportsmanSportCoach.interfaces.ISportsmanSportCoachService;

import java.util.List;

@Service
public class SportsmanSportCoachService implements ISportsmanSportCoachService {
    @Autowired
    SportsmanSportCoachDAOFakeImpl sportsmanSportCoachDAO;

    @Override
    public SportsmanSportCoach insertSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) {
        return sportsmanSportCoachDAO.insertSportsmanSportCoach(sportsmanSportCoach);
    }

    @Override
    public SportsmanSportCoach getSportsmanSportCoach(int id) {
        return sportsmanSportCoachDAO.getSportsmanSportCoach(id);
    }

    @Override
    public SportsmanSportCoach updateSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) {
        return sportsmanSportCoachDAO.updateSportsmanSportCoach(sportsmanSportCoach);
    }

    @Override
    public SportsmanSportCoach deleteSportsmanSportCoach(int id) {
        return sportsmanSportCoachDAO.deleteSportsmanSportCoach(id);
    }

    @Override
    public List<SportsmanSportCoach> getAll() {
        return sportsmanSportCoachDAO.getAll();
    }
}
