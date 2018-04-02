package osadchuk.roman.DAO.sportCategory.interfaces;

import osadchuk.roman.model.SportCategory;

import java.util.List;

public interface ISportCategoryDAO {
    public SportCategory insertSportCategory(SportCategory sportCategory);
    public SportCategory getSportCategory(int id);
    public SportCategory updateSportCategory(SportCategory sportCategory);
    public SportCategory deleteSportCategory(int id);
    public List<SportCategory> getAll();
}
