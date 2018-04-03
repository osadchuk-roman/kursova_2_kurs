package osadchuk.roman.DAO.sportsman.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportsman.interfaces.ISportsmanDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.Sportsman;

import java.util.List;

@Component
public class SportsmanDAOFakeImpl implements ISportsmanDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public Sportsman insertSportsman(Sportsman sportsman) {
        dataStorage.getSportsmen().add(sportsman);
        return sportsman;
    }

    @Override
    public Sportsman getSportsman(int id) {
        return dataStorage.getSportsmen().get(id);
    }

    @Override
    public Sportsman updateSportsman(Sportsman sportsman) {
        for (Sportsman s : dataStorage.getSportsmen()) {
            if(s.getId() == sportsman.getId()){
                s.setName(sportsman.getName());
                s.setAge(sportsman.getAge());
                s.setGender(sportsman.getGender());
                s.setSportClub(sportsman.getSportClub());
                break;
            }
        }
        return sportsman;
    }

    @Override
    public Sportsman deleteSportsman(int id) {
        Sportsman sportsman = dataStorage.getSportsmen()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportsmen().indexOf(sportsman);
        dataStorage.getSportsmen().remove(index);
        return sportsman;
    }

    @Override
    public List<Sportsman> getAll() {
        return dataStorage.getSportsmen();
    }
}
