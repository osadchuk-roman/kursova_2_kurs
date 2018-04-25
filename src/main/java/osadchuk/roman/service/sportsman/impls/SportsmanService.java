package osadchuk.roman.service.sportsman.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportsman.impls.SportsmanDAOFakeImpl;
import osadchuk.roman.model.Sportsman;
import osadchuk.roman.service.sportsman.interfaces.ISportsmanService;

import java.sql.SQLException;
import java.util.List;

@Service
public class SportsmanService implements ISportsmanService {
    @Autowired
    SportsmanDAOFakeImpl sportsmanDAO;

    @Override
    public Sportsman insertSportsman(Sportsman sportsman) throws SQLException {
        return sportsmanDAO.insertSportsman(sportsman);
    }

    @Override
    public Sportsman getSportsman(int id) throws SQLException {
        return sportsmanDAO.getSportsman(id);
    }

    @Override
    public Sportsman updateSportsman(Sportsman sportsman) throws SQLException {
        return sportsmanDAO.updateSportsman(sportsman);
    }

    @Override
    public Sportsman deleteSportsman(int id) throws SQLException {
        return sportsmanDAO.deleteSportsman(id);
    }

    @Override
    public List<Sportsman> getAll() throws SQLException {
        return sportsmanDAO.getAll();
    }
}
