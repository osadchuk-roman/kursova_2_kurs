package osadchuk.roman.service.sportsmanCompetition.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportsmanCompetition.impls.SportsmanCompetitionDAOFakeImpl;
import osadchuk.roman.model.SportsmanCompetition;
import osadchuk.roman.service.sportsmanCompetition.interfaces.ISportsmanCompetitionService;

import java.util.List;

@Service
public class SportsmanCompetitionService implements ISportsmanCompetitionService {
    @Autowired
    SportsmanCompetitionDAOFakeImpl sportsmanCompetitionDAO;
    @Override
    public SportsmanCompetition insertSportsmanCompetition(SportsmanCompetition sportsmanCompetition) {
        return sportsmanCompetitionDAO.insertSportsmanCompetition(sportsmanCompetition);
    }

    @Override
    public SportsmanCompetition getSportsmanCompetition(int id) {
        return sportsmanCompetitionDAO.getSportsmanCompetition(id);
    }

    @Override
    public SportsmanCompetition updateSportsmanCompetition(SportsmanCompetition sportsmanCompetition) {
        return sportsmanCompetitionDAO.updateSportsmanCompetition(sportsmanCompetition);
    }

    @Override
    public SportsmanCompetition deleteSportsmanCompetition(int id) {
        return sportsmanCompetitionDAO.deleteSportsmanCompetition(id);
    }

    @Override
    public List<SportsmanCompetition> getAll() {
        return sportsmanCompetitionDAO.getAll();
    }
}
