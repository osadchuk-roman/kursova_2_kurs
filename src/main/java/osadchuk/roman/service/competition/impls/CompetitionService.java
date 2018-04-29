package osadchuk.roman.service.competition.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.competition.impls.CompetitionDAOFakeImpl;
import osadchuk.roman.model.Competition;
import osadchuk.roman.service.competition.interfaces.ICompetitionService;

import java.sql.SQLException;
import java.util.List;

@Service
public class CompetitionService implements ICompetitionService {
    @Autowired
    CompetitionDAOFakeImpl competitionDAO;

    @Override
    public Competition insertCompetition(Competition competition) throws SQLException {
        return competitionDAO.insertCompetition(competition);
    }

    @Override
    public Competition getCompetition(int id) throws SQLException {
        return competitionDAO.getCompetition(id);
    }

    @Override
    public Competition updateCompetition(Competition competition) throws SQLException {
        return competitionDAO.updateCompetition(competition);
    }

    @Override
    public Competition deleteCompetition(int id) throws SQLException {
        return competitionDAO.deleteCompetition(id);
    }

    @Override
    public List<Competition> getAll() throws SQLException {
        return competitionDAO.getAll();
    }
}
