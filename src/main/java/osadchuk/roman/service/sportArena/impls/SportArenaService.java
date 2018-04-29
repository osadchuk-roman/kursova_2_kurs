package osadchuk.roman.service.sportArena.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportArena.impls.SportArenaDAOFakeImpl;
import osadchuk.roman.model.SportArena;
import osadchuk.roman.service.sportArena.interfaces.ISportArenaService;

import java.sql.SQLException;
import java.util.List;

@Service
public class SportArenaService implements ISportArenaService {
    @Autowired
    SportArenaDAOFakeImpl sportArenaDAO;

    @Override
    public SportArena insertSportArena(SportArena sportArena) throws SQLException {
        return sportArenaDAO.insertSportArena(sportArena);
    }

    @Override
    public SportArena getSportArena(int id) throws SQLException {
        return sportArenaDAO.getSportArena(id);
    }

    @Override
    public SportArena updateSportArena(SportArena sportArena) throws SQLException {
        return sportArenaDAO.updateSportArena(sportArena);
    }

    @Override
    public SportArena deleteSportArena(int id) throws SQLException {
        return sportArenaDAO.deleteSportArena(id);
    }

    @Override
    public List<SportArena> getAll() throws SQLException {
        return sportArenaDAO.getAll();
    }
}
