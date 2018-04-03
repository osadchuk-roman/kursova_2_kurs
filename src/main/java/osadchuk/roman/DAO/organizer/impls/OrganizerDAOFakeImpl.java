package osadchuk.roman.DAO.organizer.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.organizer.interfaces.IOrganizerDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.Organizer;

import java.util.List;

@Component
public class OrganizerDAOFakeImpl implements IOrganizerDAO {
    @Autowired
    DataStorageFake dataStorage;
    @Override
    public Organizer insertOrganizer(Organizer organizer) {
        dataStorage.getOrganizes().add(organizer);
        return organizer;
    }

    @Override
    public Organizer getOrganizer(int id) {
        return dataStorage.getOrganizes().get(id);
    }

    @Override
    public Organizer updateOrganizer(Organizer organizer) {
        for (Organizer o : dataStorage.getOrganizes()) {
            if(o.getId() == organizer.getId()){
                o.setName(organizer.getName());
                o.setAdminName(organizer.getAdminName());
                o.setPhone(organizer.getPhone());
                o.setAddress(organizer.getAddress());
                break;
            }
        }
        return organizer;
    }

    @Override
    public Organizer deleteOrganizer(int id) {
        Organizer organizer = dataStorage.getOrganizes()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getOrganizes().indexOf(organizer);
        dataStorage.getOrganizes().remove(index);
        return organizer;
    }

    @Override
    public List<Organizer> getAll() {
        return dataStorage.getOrganizes();
    }
}
