package osadchuk.roman.service.sportCategory.interfaces;

import osadchuk.roman.model.SportCategory;

import java.sql.SQLException;
import java.util.List;

public interface ISportCategoryService {
    public SportCategory insertSportCategory(SportCategory sportCategory) throws SQLException;
    public SportCategory getSportCategory(int id) throws SQLException;
    public SportCategory updateSportCategory(SportCategory sportCategory) throws SQLException;
    public SportCategory deleteSportCategory(int id) throws SQLException;
    public List<SportCategory> getAll() throws SQLException;
}
