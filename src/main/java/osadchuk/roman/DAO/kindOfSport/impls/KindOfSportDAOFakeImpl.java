package osadchuk.roman.DAO.kindOfSport.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.kindOfSport.interfaces.IKindOfSportDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.KindOfSport;

import java.util.List;

@Component
public class KindOfSportDAOFakeImpl implements IKindOfSportDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
    public KindOfSport insertKindOfSport(KindOfSport kindOfSport) {
        dataStorage.getKindsOfSports().add(kindOfSport);
        return  kindOfSport;
    }

    @Override
    public KindOfSport getKindOfSport(int id) {
        return dataStorage.getKindsOfSports().get(id);
    }

    @Override
    public KindOfSport updateKindOfSport(KindOfSport kindOfSport) {
        for (KindOfSport sport : dataStorage.getKindsOfSports()) {
            if(sport.getId() == kindOfSport.getId()){
                sport.setName(kindOfSport.getName());
                break;
            }
        }
        return kindOfSport;
    }

    @Override
    public KindOfSport deleteKindOfSport(int id) {System.err.println("id = " + id);
        KindOfSport kindOfSport = dataStorage.getKindsOfSports()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getKindsOfSports().indexOf(kindOfSport);
        dataStorage.getKindsOfSports().remove(index);
        return kindOfSport;
    }

    @Override
    public List<KindOfSport> getAll() {
        return dataStorage.getKindsOfSports();
    }
}
