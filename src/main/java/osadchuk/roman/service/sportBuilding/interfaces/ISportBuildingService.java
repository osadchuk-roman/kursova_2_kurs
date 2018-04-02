package osadchuk.roman.service.sportBuilding.interfaces;

import osadchuk.roman.model.SportBuilding;

import java.util.List;

public interface ISportBuildingService {
    public SportBuilding insertSportBuilding(SportBuilding sportBuilding);
    public SportBuilding getSportBuilding(int id);
    public SportBuilding updateSportBuilding(SportBuilding sportBuilding);
    public SportBuilding deleteSportBuilding(int id);
    public List<SportBuilding> getAll();
}
