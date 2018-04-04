package osadchuk.roman.service.sportBuildingSport.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportBuildingSport.impls.SportBuildingSportDAOFakeImpl;
import osadchuk.roman.model.SportBuildingSport;
import osadchuk.roman.service.sportBuildingSport.interfaces.ISportBuildingSportService;

import java.util.List;

@Service
public class SportBuildingSportService implements ISportBuildingSportService {
    @Autowired
    SportBuildingSportDAOFakeImpl sportBuildingSportDAO;
    @Override
    public SportBuildingSport insertSportBuildingSport(SportBuildingSport sportBuildingSport) {
        return sportBuildingSportDAO.insertSportBuildingSport(sportBuildingSport);
    }

    @Override
    public SportBuildingSport getSportBuildingSport(int id) {
        return sportBuildingSportDAO.getSportBuildingSport(id);
    }

    @Override
    public SportBuildingSport updateSportBuildingSport(SportBuildingSport sportBuildingSport) {
        return sportBuildingSportDAO.updateSportBuildingSport(sportBuildingSport);
    }

    @Override
    public SportBuildingSport deleteSportBuildingSport(int id) {
        return sportBuildingSportDAO.deleteSportBuildingSport(id);
    }

    @Override
    public List<SportBuildingSport> getAll() {
        return sportBuildingSportDAO.getAll();
    }
}
