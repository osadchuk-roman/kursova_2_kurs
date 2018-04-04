package osadchuk.roman.DAO.sportsmanCompetition.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportsmanCompetition.interfaces.ISportsmanCompetitionDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.SportsmanCompetition;

import java.util.List;
@Component
public class SportsmanCompetitionDAOFakeImpl implements ISportsmanCompetitionDAO {
    @Autowired
    DataStorageFake dataStorage;
    @Override
    public SportsmanCompetition insertSportsmanCompetition(SportsmanCompetition sportsmanCompetition) {
        dataStorage.getSportsmanCompetitions().add(sportsmanCompetition);
        return sportsmanCompetition;
    }

    @Override
    public SportsmanCompetition getSportsmanCompetition(int id) {
        return dataStorage.getSportsmanCompetitions().get(id);
    }

    @Override
    public SportsmanCompetition updateSportsmanCompetition(SportsmanCompetition sportsmanCompetition) {
        for (SportsmanCompetition sc : dataStorage.getSportsmanCompetitions()) {
            if(sc.getId() == sportsmanCompetition.getId()){
                sc.setSportsman(sportsmanCompetition.getSportsman());
                sc.setCompetition(sportsmanCompetition.getCompetition());
                sc.setPrizePlace(sportsmanCompetition.getPrizePlace());
                break;
            }
        }
        return sportsmanCompetition;
    }

    @Override
    public SportsmanCompetition deleteSportsmanCompetition(int id) {
        SportsmanCompetition sportsmanCompetition = dataStorage.getSportsmanCompetitions()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportsmanCompetitions().indexOf(sportsmanCompetition);
        dataStorage.getSportsmanCompetitions().remove(index);
        return sportsmanCompetition;
    }

    @Override
    public List<SportsmanCompetition> getAll() {
        return dataStorage.getSportsmanCompetitions();
    }
}
