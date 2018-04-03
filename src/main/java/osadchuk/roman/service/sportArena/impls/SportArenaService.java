package osadchuk.roman.service.sportArena.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportArena.impls.SportArenaDAOFakeImpl;
import osadchuk.roman.model.SportArena;
import osadchuk.roman.service.sportArena.interfaces.ISportArenaService;

import java.util.List;

@Service
public class SportArenaService implements ISportArenaService {
    @Autowired
    SportArenaDAOFakeImpl sportArenaDAO;

    @Override
    public SportArena insertSportArena(SportArena sportArena) {
        return sportArenaDAO.insertSportArena(sportArena);
    }

    @Override
    public SportArena getSportArena(int id) {
        return sportArenaDAO.getSportArena(id);
    }

    @Override
    public SportArena updateSportArena(SportArena sportArena) {
        return sportArenaDAO.updateSportArena(sportArena);
    }

    @Override
    public SportArena deleteSportArena(int id) {
        return sportArenaDAO.deleteSportArena(id);
    }

    @Override
    public List<SportArena> getAll() {
        return sportArenaDAO.getAll();
    }
}
