package osadchuk.roman.service.stadium.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.stadium.impls.StadiumDAOFakeImpl;
import osadchuk.roman.model.Stadium;
import osadchuk.roman.service.stadium.interfaces.IStadiumService;

import java.util.List;

@Service
public class StadiumService implements IStadiumService {
    @Autowired
    StadiumDAOFakeImpl stadiumDAO;

    @Override
    public Stadium insertStadium(Stadium stadium) {
        return stadiumDAO.insertStadium(stadium);
    }

    @Override
    public Stadium getStadium(int id) {
        return stadiumDAO.getStadium(id);
    }

    @Override
    public Stadium updateStadium(Stadium stadium) {
        return stadiumDAO.updateStadium(stadium);
    }

    @Override
    public Stadium deleteStadium(int id) {
        return stadiumDAO.deleteStadium(id);
    }

    @Override
    public List<Stadium> getAll() {
        return stadiumDAO.getAll();
    }
}
