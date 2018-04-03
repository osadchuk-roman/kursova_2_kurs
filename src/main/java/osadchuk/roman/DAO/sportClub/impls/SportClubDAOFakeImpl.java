package osadchuk.roman.DAO.sportClub.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportClub.interfaces.ISportClubDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.SportClub;

import java.util.List;

@Component
public class SportClubDAOFakeImpl implements ISportClubDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public SportClub insertSportClub(SportClub sportClub) {
        dataStorage.getSportClubs().add(sportClub);
        return sportClub;
    }

    @Override
    public SportClub getSportClub(int id) {
        return dataStorage.getSportClubs().get(id);
    }

    @Override
    public SportClub updateSportClub(SportClub sportClub) {
        for (SportClub sc : dataStorage.getSportClubs()) {
            if(sc.getId() == sportClub.getId()){
                sc.setName(sportClub.getName());
                sc.setAdminName(sportClub.getAdminName());
                sc.setPhone(sportClub.getPhone());
                sc.setAddress(sportClub.getAddress());
                break;
            }
        }
        return sportClub;
    }

    @Override
    public SportClub deleteSportClub(int id) {
        SportClub sportClub = dataStorage.getSportClubs()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportClubs().indexOf(sportClub);
        dataStorage.getSportClubs().remove(index);
        return sportClub;
    }

    @Override
    public List<SportClub> getAll() {
        return dataStorage.getSportClubs();
    }
}
