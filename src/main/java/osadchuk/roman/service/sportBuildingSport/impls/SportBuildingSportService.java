package osadchuk.roman.service.sportBuildingSport.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportBuildingSport.impls.SportBuildingSportDAOFakeImpl;
import osadchuk.roman.model.SportBuildingSport;
import osadchuk.roman.service.sportBuildingSport.interfaces.ISportBuildingSportService;

import java.sql.SQLException;
import java.util.List;

@Service
public class SportBuildingSportService implements ISportBuildingSportService {
    @Autowired
    SportBuildingSportDAOFakeImpl sportBuildingSportDAO;
    @Override
    public SportBuildingSport insertSportBuildingSport(SportBuildingSport sportBuildingSport) throws SQLException {
        return sportBuildingSportDAO.insertSportBuildingSport(sportBuildingSport);
    }

    @Override
    public SportBuildingSport getSportBuildingSport(int id) throws SQLException {
        return sportBuildingSportDAO.getSportBuildingSport(id);
    }

    @Override
    public SportBuildingSport updateSportBuildingSport(SportBuildingSport sportBuildingSport) throws SQLException {
        return sportBuildingSportDAO.updateSportBuildingSport(sportBuildingSport);
    }

    @Override
    public SportBuildingSport deleteSportBuildingSport(int id) throws SQLException {
        return sportBuildingSportDAO.deleteSportBuildingSport(id);
    }

    @Override
    public List<SportBuildingSport> getAll() throws SQLException {
        return sportBuildingSportDAO.getAll();
    }
}
