package osadchuk.roman.DAO.organizer.interfaces;

import osadchuk.roman.model.Organizer;

import java.sql.SQLException;
import java.util.List;

public interface IOrganizerDAO {
    public Organizer insertOrganizer(Organizer organizer) throws SQLException;
    public Organizer getOrganizer(int id) throws SQLException;
    public Organizer updateOrganizer(Organizer organizer) throws SQLException;
    public Organizer deleteOrganizer(int id) throws SQLException;
    public List<Organizer> getAll() throws SQLException;
}
