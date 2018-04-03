package osadchuk.roman.service.sportBuilding.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportBuilding.impls.SportBuildingDAOFakeImpl;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.service.sportBuilding.interfaces.ISportBuildingService;

import java.util.List;

@Service
public class SportBuildingService implements ISportBuildingService {
    @Autowired
    SportBuildingDAOFakeImpl sportBuildingDAO;

    @Override
    public SportBuilding insertSportBuilding(SportBuilding sportBuilding) {
        return sportBuildingDAO.insertSportBuilding(sportBuilding);
    }

    @Override
    public SportBuilding getSportBuilding(int id) {
        return sportBuildingDAO.getSportBuilding(id);
    }

    @Override
    public SportBuilding updateSportBuilding(SportBuilding sportBuilding) {
        return sportBuildingDAO.updateSportBuilding(sportBuilding);
    }

    @Override
    public SportBuilding deleteSportBuilding(int id) {
        return sportBuildingDAO.deleteSportBuilding(id);
    }

    @Override
    public List<SportBuilding> getAll() {
        return sportBuildingDAO.getAll();
    }
}
