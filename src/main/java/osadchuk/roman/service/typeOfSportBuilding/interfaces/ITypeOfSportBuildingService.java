package osadchuk.roman.service.typeOfSportBuilding.interfaces;

import osadchuk.roman.model.TypeOfSportBuilding;

import java.sql.SQLException;
import java.util.List;

public interface ITypeOfSportBuildingService {
    public TypeOfSportBuilding insertTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) throws SQLException;
    public TypeOfSportBuilding getTypeOfSportBuilding(int id) throws SQLException;
    public TypeOfSportBuilding updateTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) throws SQLException;
    public TypeOfSportBuilding deleteTypeOfSportBuilding(int id) throws SQLException;
    public List<TypeOfSportBuilding> getAll() throws SQLException;
}
