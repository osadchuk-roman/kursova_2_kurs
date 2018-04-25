package osadchuk.roman.service.sportBuilding.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportBuilding.impls.SportBuildingDAOFakeImpl;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.sportBuilding.interfaces.ISportBuildingService;

import java.sql.SQLException;
import java.util.List;

@Service
public class SportBuildingService implements ISportBuildingService {
    @Autowired
    SportBuildingDAOFakeImpl sportBuildingDAO;

    @Override
    public SportBuilding insertSportBuilding(SportBuilding sportBuilding) throws SQLException {
        return sportBuildingDAO.insertSportBuilding(sportBuilding);
    }

    @Override
    public SportBuilding getSportBuilding(int id) throws SQLException {
        return sportBuildingDAO.getSportBuilding(id);
    }

    @Override
    public SportBuilding updateSportBuilding(SportBuilding sportBuilding) throws SQLException {
        return sportBuildingDAO.updateSportBuilding(sportBuilding);
    }

    @Override
    public SportBuilding deleteSportBuilding(int id) throws SQLException {
        return sportBuildingDAO.deleteSportBuilding(id);
    }

    @Override
    public List<SportBuilding> getAll() throws SQLException {
        return sportBuildingDAO.getAll();
    }
}
