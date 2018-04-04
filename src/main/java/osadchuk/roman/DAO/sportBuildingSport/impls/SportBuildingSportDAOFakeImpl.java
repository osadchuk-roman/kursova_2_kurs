package osadchuk.roman.DAO.sportBuildingSport.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportBuildingSport.interfaces.ISportBuildingSportDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.SportBuildingSport;

import java.util.List;

@Component
public class SportBuildingSportDAOFakeImpl implements ISportBuildingSportDAO {
    @Autowired
    DataStorageFake dataStorage;
    @Override
    public SportBuildingSport insertSportBuildingSport(SportBuildingSport sportBuildingSport) {
        dataStorage.getSportBuildingSports().add(sportBuildingSport);
        return sportBuildingSport;
    }

    @Override
    public SportBuildingSport getSportBuildingSport(int id) {
        return dataStorage.getSportBuildingSports().get(id);
    }

    @Override
    public SportBuildingSport updateSportBuildingSport(SportBuildingSport sportBuildingSport) {
        for (SportBuildingSport sbs : dataStorage.getSportBuildingSports()) {
            if(sbs.getId() == sportBuildingSport.getId()){
                sbs.setKindOfSport(sportBuildingSport.getKindOfSport());
                sbs.setSportBuilding(sportBuildingSport.getSportBuilding());
                break;
            }
        }
        return sportBuildingSport;
    }

    @Override
    public SportBuildingSport deleteSportBuildingSport(int id) {
        SportBuildingSport sportBuildingSport = dataStorage.getSportBuildingSports()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportBuildingSports().indexOf(sportBuildingSport);
        dataStorage.getSportBuildingSports().remove(index);
        return sportBuildingSport;
    }

    @Override
    public List<SportBuildingSport> getAll() {
        return dataStorage.getSportBuildingSports();
    }
}
