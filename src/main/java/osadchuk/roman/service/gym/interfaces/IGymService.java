package osadchuk.roman.service.gym.interfaces;

import osadchuk.roman.model.Gym;

import java.util.List;

public interface IGymService {
    public Gym insertGym(Gym gym);
    public Gym getGym(int id);
    public Gym updateGym(Gym gym);
    public Gym deleteGym(int id);
    public List<Gym> getAll();
}
