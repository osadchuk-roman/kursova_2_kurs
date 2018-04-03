package osadchuk.roman.DAO.gym.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.gym.interfaces.IGymDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.Gym;

import java.util.List;

@Component
public class GymDAOFakeImpl implements IGymDAO {
    @Autowired
    DataStorageFake dataStorage;


    @Override
    public Gym insertGym(Gym gym) {
        dataStorage.getGyms().add(gym);
        return gym;
    }

    @Override
    public Gym getGym(int id) {
        return dataStorage.getGyms().get(id);
    }

    @Override
    public Gym updateGym(Gym gym) {
        for (Gym g : dataStorage.getGyms()) {
            if(g.getId() == gym.getId()){
                g.setSportBuilding(gym.getSportBuilding());
                g.setPresenceOfBoxingRing(gym.getPresenceOfBoxingRing());
                g.setPresenceOfCardioZone(gym.getPresenceOfCardioZone());
                g.setPresenceOfCrossfitZone(gym.getPresenceOfCrossfitZone());
                break;
            }
        }
        return gym;
    }

    @Override
    public Gym deleteGym(int id) {
        Gym gym = dataStorage.getGyms()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getGyms().indexOf(gym);
        dataStorage.getGyms().remove(index);
        return gym;
    }

    @Override
    public List<Gym> getAll() {
        return dataStorage.getGyms();
    }
}
