package osadchuk.roman.service.court.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.court.impls.CourtDAOFakeImpl;
import osadchuk.roman.model.Court;
import osadchuk.roman.service.court.interfaces.ICourtService;

import java.util.List;

@Service
public class CourtService implements ICourtService {
    @Autowired
    CourtDAOFakeImpl courtDAO;

    @Override
    public Court insertCourt(Court court) {
        return courtDAO.insertCourt(court);
    }

    @Override
    public Court getCourt(int id) {
        return courtDAO.getCourt(id);
    }

    @Override
    public Court updateCourt(Court court) {
        return courtDAO.updateCourt(court);
    }

    @Override
    public Court deleteCourt(int id) {
        return courtDAO.deleteCourt(id);
    }

    @Override
    public List<Court> getAll() {
        return courtDAO.getAll();
    }
}
