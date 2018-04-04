package osadchuk.roman.DAO.sportsmanSportCoach.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportsmanSportCoach.interfaces.ISportsmanSportCoachDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.SportsmanSportCoach;

import java.util.List;
@Component
public class SportsmanSportCoachDAOFakeImpl implements ISportsmanSportCoachDAO {
    @Autowired
    DataStorageFake dataStorage;
    @Override
    public SportsmanSportCoach insertSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) {
        dataStorage.getSportsmanSportCoaches().add(sportsmanSportCoach);
        return sportsmanSportCoach;
    }

    @Override
    public SportsmanSportCoach getSportsmanSportCoach(int id) {
        return dataStorage.getSportsmanSportCoaches().get(id);
    }

    @Override
    public SportsmanSportCoach updateSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) {
        for (SportsmanSportCoach sportsmanSportCoach1 : dataStorage.getSportsmanSportCoaches()) {
            if(sportsmanSportCoach1.getId() == sportsmanSportCoach.getId()){
                sportsmanSportCoach1.setKindOfSport(sportsmanSportCoach.getKindOfSport());
                sportsmanSportCoach1.setCoach(sportsmanSportCoach.getCoach());
                sportsmanSportCoach1.setSportCategory(sportsmanSportCoach.getSportCategory());
                sportsmanSportCoach1.setSportsman(sportsmanSportCoach.getSportsman());
                break;
            }
        }
        return sportsmanSportCoach;
    }

    @Override
    public SportsmanSportCoach deleteSportsmanSportCoach(int id) {
        SportsmanSportCoach sportsmanSportCoach = dataStorage.getSportsmanSportCoaches()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportsmanSportCoaches().indexOf(sportsmanSportCoach);
        dataStorage.getSportsmanSportCoaches().remove(index);
        return sportsmanSportCoach;
    }

    @Override
    public List<SportsmanSportCoach> getAll() {
        return dataStorage.getSportsmanSportCoaches();
    }
}
