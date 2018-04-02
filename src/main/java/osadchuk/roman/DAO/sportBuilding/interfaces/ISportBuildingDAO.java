package osadchuk.roman.DAO.sportBuilding.interfaces;

import osadchuk.roman.model.SportBuilding;

import java.util.List;

public interface ISportBuildingDAO {
    public SportBuilding insertSportBuilding(SportBuilding sportBuilding);
    public SportBuilding getSportBuilding(int id);
    public SportBuilding updateSportBuilding(SportBuilding sportBuilding);
    public SportBuilding deleteSportBuilding(int id);
    public List<SportBuilding> getAll();
}
