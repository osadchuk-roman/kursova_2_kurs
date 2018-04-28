package osadchuk.roman.DAO.gym.interfaces;

import osadchuk.roman.model.Gym;

import java.sql.SQLException;
import java.util.List;

public interface IGymDAO {
    public Gym insertGym(Gym gym) throws SQLException;
    public Gym getGym(int id) throws SQLException;
    public Gym updateGym(Gym gym) throws SQLException;
    public Gym deleteGym(int id) throws SQLException;
    public List<Gym> getAll() throws SQLException;
}
