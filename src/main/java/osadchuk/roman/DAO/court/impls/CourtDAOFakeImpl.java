package osadchuk.roman.DAO.court.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.court.interfaces.ICourtDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.Court;

import java.util.List;

@Component
public class CourtDAOFakeImpl implements ICourtDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public Court insertCourt(Court court) {
        dataStorage.getCourts().add(court);
        return court;
    }

    @Override
    public Court getCourt(int id) {
        return dataStorage.getCourts().get(id);
    }

    @Override
    public Court updateCourt(Court court) {
        for (Court c : dataStorage.getCourts()) {
            if(c.getId() == court.getId()){
                c.setSportBuilding(court.getSportBuilding());
                c.setTypeOfCover(court.getTypeOfCover());
                c.setLength(court.getLength());
                c.setWidth(court.getWidth());
                break;
            }
        }
        return court;
    }

    @Override
    public Court deleteCourt(int id) {
        Court court = dataStorage.getCourts()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getCourts().indexOf(court);
        dataStorage.getCourts().remove(index);
        return court;
    }

    @Override
    public List<Court> getAll() {
        return dataStorage.getCourts();
    }
}
