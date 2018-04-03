package osadchuk.roman.DAO.coach.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.coach.interfaces.ICoachDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.Coach;

import java.util.List;

@Component
public class CoachDAOFakeImpl implements ICoachDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public Coach insertCoach(Coach coach) {
        dataStorage.getCoaches().add(coach);
        return coach;
    }

    @Override
    public Coach getCoach(int id) {
        return dataStorage.getCoaches().get(id);
    }

    @Override
    public Coach updateCoach(Coach coach) {
        for (Coach c : dataStorage.getCoaches()) {
            if(c.getId() == coach.getId()){
                c.setName(coach.getName());
                c.setSportClub(coach.getSportClub());
                break;
            }
        }
        return coach;
    }

    @Override
    public Coach deleteCoach(int id) {
        Coach coach = dataStorage.getCoaches()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getCoaches().indexOf(coach);
        dataStorage.getCoaches().remove(index);
        return coach;
    }

    @Override
    public List<Coach> getAll() {
        return dataStorage.getCoaches();
    }
}
