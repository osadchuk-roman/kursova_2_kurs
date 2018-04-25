package osadchuk.roman.service.sportCategory.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.sportCategory.impls.SportCategoryDAOFakeImpl;
import osadchuk.roman.model.SportCategory;
import osadchuk.roman.service.sportCategory.interfaces.ISportCategoryService;

import java.sql.SQLException;
import java.util.List;

@Service
public class SportCategoryService implements ISportCategoryService {
    @Autowired
    SportCategoryDAOFakeImpl sportCategoryDAO;
    @Override
    public SportCategory insertSportCategory(SportCategory sportCategory) throws SQLException {
        return sportCategoryDAO.insertSportCategory(sportCategory);
    }

    @Override
    public SportCategory getSportCategory(int id) throws SQLException {
        return sportCategoryDAO.getSportCategory(id);
    }

    @Override
    public SportCategory updateSportCategory(SportCategory sportCategory) throws SQLException {
        return sportCategoryDAO.updateSportCategory(sportCategory);
    }

    @Override
    public SportCategory deleteSportCategory(int id) throws SQLException {
        return sportCategoryDAO.deleteSportCategory(id);
    }

    @Override
    public List<SportCategory> getAll() throws SQLException {
        return sportCategoryDAO.getAll();
    }
}
