package osadchuk.roman.DAO.sportBuilding.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportBuilding.interfaces.ISportBuildingDAO;
import osadchuk.roman.DAO.sportBuildingSport.interfaces.ISportBuildingSportDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.SportBuildingSport;

import java.util.List;

@Component
public class SportBuildingDAOFakeImpl implements ISportBuildingDAO {
    @Autowired
    DataStorageFake dataStorage;


    @Override
    public SportBuilding insertSportBuilding(SportBuilding sportBuilding) {
        dataStorage.getSportBuilding().add(sportBuilding);
        return sportBuilding;
    }

    @Override
    public SportBuilding getSportBuilding(int id) {
        return dataStorage.getSportBuilding().get(id);
    }

    @Override
    public SportBuilding updateSportBuilding(SportBuilding sportBuilding) {
        for (SportBuilding sb : dataStorage.getSportBuilding()) {
            if(sb.getId() == sportBuilding.getId()){
                sb.setName(sportBuilding.getName());
                break;
            }
        }
        return sportBuilding;
    }

    @Override
    public SportBuilding deleteSportBuilding(int id) {
        SportBuilding sportBuilding = dataStorage.getSportBuilding()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportBuilding().indexOf(sportBuilding);
        dataStorage.getSportBuilding().remove(index);
        return sportBuilding;
    }

    @Override
    public List<SportBuilding> getAll() {
        return dataStorage.getSportBuilding();
    }
}
