package osadchuk.roman.DAO.court.interfaces;

import osadchuk.roman.model.Court;

import java.util.List;

public interface ICourtDAO {
    public Court insertCourt(Court court);
    public Court getCourt(int id);
    public Court updateCourt(Court court);
    public Court deleteCourt(int id);
    public List<Court> getAll();
}
