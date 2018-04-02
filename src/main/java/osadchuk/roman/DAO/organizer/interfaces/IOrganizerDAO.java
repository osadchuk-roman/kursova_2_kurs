package osadchuk.roman.DAO.organizer.interfaces;

import osadchuk.roman.model.Organizer;

import java.util.List;

public interface IOrganizerDAO {
    public Organizer insertOrganizer(Organizer organizer);
    public Organizer getOrganizer(int id);
    public Organizer updateOrganizer(Organizer organizer);
    public Organizer deleteOrganizer(int id);
    public List<Organizer> getAll();
}