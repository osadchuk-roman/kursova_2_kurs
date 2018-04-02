package osadchuk.roman.DAO.typeOfSportBuilding.interfaces;

import osadchuk.roman.model.TypeOfSportBuilding;

import java.util.List;

public interface ITypeOfSportBuildingDAO {
    public TypeOfSportBuilding insertTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding);
    public TypeOfSportBuilding getTypeOfSportBuilding(int id);
    public TypeOfSportBuilding updateTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding);
    public TypeOfSportBuilding deleteTypeOfSportBuilding(int id);
    public List<TypeOfSportBuilding> getAll();
}
