package osadchuk.roman.service.stadium.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.stadium.impls.StadiumDAOFakeImpl;
import osadchuk.roman.model.Stadium;
import osadchuk.roman.service.stadium.interfaces.IStadiumService;

import java.sql.SQLException;
import java.util.List;

@Service
public class StadiumService implements IStadiumService {
    @Autowired
    StadiumDAOFakeImpl stadiumDAO;

    @Override
    public Stadium insertStadium(Stadium stadium) throws SQLException {
        return stadiumDAO.insertStadium(stadium);
    }

    @Override
    public Stadium getStadium(int id) throws SQLException {
        return stadiumDAO.getStadium(id);
    }

    @Override
    public Stadium updateStadium(Stadium stadium) throws SQLException {
        return stadiumDAO.updateStadium(stadium);
    }

    @Override
    public Stadium deleteStadium(int id) throws SQLException {
        return stadiumDAO.deleteStadium(id);
    }

    @Override
    public List<Stadium> getAll() throws SQLException {
        return stadiumDAO.getAll();
    }
}
