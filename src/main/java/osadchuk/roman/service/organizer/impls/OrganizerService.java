package osadchuk.roman.service.organizer.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.organizer.impls.OrganizerDAOFakeImpl;
import osadchuk.roman.model.Organizer;
import osadchuk.roman.service.organizer.interfaces.IOrganizerService;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrganizerService implements IOrganizerService {
    @Autowired
    OrganizerDAOFakeImpl organizerDAO;
    @Override
    public Organizer insertOrganizer(Organizer organizer) throws SQLException {
        return organizerDAO.insertOrganizer(organizer);
    }

    @Override
    public Organizer getOrganizer(int id) throws SQLException {
        return organizerDAO.getOrganizer(id);
    }

    @Override
    public Organizer updateOrganizer(Organizer organizer) throws SQLException {
        return organizerDAO.updateOrganizer(organizer);
    }

    @Override
    public Organizer deleteOrganizer(int id) throws SQLException {
        return organizerDAO.deleteOrganizer(id);
    }

    @Override
    public List<Organizer> getAll() throws SQLException {
        return organizerDAO.getAll();
    }
}
