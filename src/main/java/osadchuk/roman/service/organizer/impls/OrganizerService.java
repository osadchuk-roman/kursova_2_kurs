package osadchuk.roman.service.organizer.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.organizer.impls.OrganizerDAOFakeImpl;
import osadchuk.roman.model.Organizer;
import osadchuk.roman.service.organizer.interfaces.IOrganizerService;

import java.util.List;

@Service
public class OrganizerService implements IOrganizerService {
    @Autowired
    OrganizerDAOFakeImpl organizerDAO;
    @Override
    public Organizer insertOrganizer(Organizer organizer) {
        return organizerDAO.insertOrganizer(organizer);
    }

    @Override
    public Organizer getOrganizer(int id) {
        return organizerDAO.getOrganizer(id);
    }

    @Override
    public Organizer updateOrganizer(Organizer organizer) {
        return organizerDAO.updateOrganizer(organizer);
    }

    @Override
    public Organizer deleteOrganizer(int id) {
        return organizerDAO.deleteOrganizer(id);
    }

    @Override
    public List<Organizer> getAll() {
        return organizerDAO.getAll();
    }
}
