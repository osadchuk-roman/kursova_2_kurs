package osadchuk.roman.DAO.stadium.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.stadium.interfaces.IStadiumDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.Stadium;

import java.util.List;

@Component
public class StadiumDAOFakeImpl implements IStadiumDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public Stadium insertStadium(Stadium stadium) {
        dataStorage.getStadiums().add(stadium);
        return stadium;
    }

    @Override
    public Stadium getStadium(int id) {
        return dataStorage.getStadiums().get(id);
    }

    @Override
    public Stadium updateStadium(Stadium stadium) {
        for (Stadium s : dataStorage.getStadiums()) {
            if(s.getId() == stadium.getId()){
                s.setSportBuilding(stadium.getSportBuilding());
                s.setCapacity(stadium.getCapacity());
                s.setFieldArea(stadium.getFieldArea());
                s.setPresenceOfGymnasticZone(stadium.getPresenceOfGymnasticZone());
                s.setPresenceOfPathForRunning(stadium.getPresenceOfPathForRunning());
            }
        }
        return stadium;
    }

    @Override
    public Stadium deleteStadium(int id) {
        Stadium stadium = dataStorage.getStadiums()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getStadiums().indexOf(stadium);
        dataStorage.getStadiums().remove(index);
        return stadium;
    }

    @Override
    public List<Stadium> getAll() {
        return dataStorage.getStadiums();
    }
}
