package osadchuk.roman.service.gym.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.gym.impls.GymDAOFakeImpl;
import osadchuk.roman.model.Gym;
import osadchuk.roman.service.gym.interfaces.IGymService;

import java.util.List;

@Service
public class GymService implements IGymService {
    @Autowired
    GymDAOFakeImpl gymDAO;

    @Override
    public Gym insertGym(Gym gym) {
        return gymDAO.insertGym(gym);
    }

    @Override
    public Gym getGym(int id) {
        return gymDAO.getGym(id);
    }

    @Override
    public Gym updateGym(Gym gym) {
        return gymDAO.updateGym(gym);
    }

    @Override
    public Gym deleteGym(int id) {
        return gymDAO.deleteGym(id);
    }

    @Override
    public List<Gym> getAll() {
        return gymDAO.getAll();
    }
}
