package osadchuk.roman.service.court.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.court.impls.CourtDAOFakeImpl;
import osadchuk.roman.model.Court;
import osadchuk.roman.service.court.interfaces.ICourtService;

import java.sql.SQLException;
import java.util.List;

@Service
public class CourtService implements ICourtService {
    @Autowired
    CourtDAOFakeImpl courtDAO;

    @Override
    public Court insertCourt(Court court) throws SQLException {
        return courtDAO.insertCourt(court);
    }

    @Override
    public Court getCourt(int id) throws SQLException {
        return courtDAO.getCourt(id);
    }

    @Override
    public Court updateCourt(Court court) throws SQLException {
        return courtDAO.updateCourt(court);
    }

    @Override
    public Court deleteCourt(int id) throws SQLException {
        return courtDAO.deleteCourt(id);
    }

    @Override
    public List<Court> getAll() throws SQLException {
        return courtDAO.getAll();
    }
}
