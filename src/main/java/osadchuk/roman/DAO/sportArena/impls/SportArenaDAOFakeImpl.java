package osadchuk.roman.DAO.sportArena.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import osadchuk.roman.DAO.sportArena.interfaces.ISportArenaDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.SportArena;

import java.util.List;

@Controller
public class SportArenaDAOFakeImpl implements ISportArenaDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public SportArena insertSportArena(SportArena sportArena) {
        dataStorage.getSportArena().add(sportArena);
        return sportArena;
    }

    @Override
    public SportArena getSportArena(int id) {
        return dataStorage.getSportArena().get(id);
    }

    @Override
    public SportArena updateSportArena(SportArena sportArena) {
        for (SportArena s : dataStorage.getSportArena()) {
            if(s.getId() == sportArena.getId()){
                s.setSportBuilding(sportArena.getSportBuilding());
                s.setCapacity(sportArena.getCapacity());
                s.setPresenceOfGymnasticZone(sportArena.getPresenceOfGymnasticZone());
                s.setPresenceOfBoxingRing(sportArena.getPresenceOfBoxingRing());
                s.setPresenceOfMatirialArtsZone(sportArena.getPresenceOfMatirialArtsZone());
            }
        }
        return sportArena;
    }

    @Override
    public SportArena deleteSportArena(int id) {
        SportArena sportArena = dataStorage.getSportArena()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportArena().indexOf(sportArena);
        dataStorage.getSportArena().remove(index);
        return sportArena;
    }

    @Override
    public List<SportArena> getAll() {
        return dataStorage.getSportArena();
    }
}
