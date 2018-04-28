package osadchuk.roman.service.gym.interfaces;

import osadchuk.roman.model.Gym;

import java.sql.SQLException;
import java.util.List;

public interface IGymService {
    public Gym insertGym(Gym gym) throws SQLException;
    public Gym getGym(int id) throws SQLException;
    public Gym updateGym(Gym gym) throws SQLException;
    public Gym deleteGym(int id) throws SQLException;
    public List<Gym> getAll() throws SQLException;
}
