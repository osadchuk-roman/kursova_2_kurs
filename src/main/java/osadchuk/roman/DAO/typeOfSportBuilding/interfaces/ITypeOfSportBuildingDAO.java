package osadchuk.roman.DAO.typeOfSportBuilding.interfaces;

import osadchuk.roman.model.TypeOfSportBuilding;

import java.sql.SQLException;
import java.util.List;

public interface ITypeOfSportBuildingDAO {
    public TypeOfSportBuilding insertTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) throws SQLException;
    public TypeOfSportBuilding getTypeOfSportBuilding(int id) throws SQLException;
    public TypeOfSportBuilding updateTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) throws SQLException;
    public TypeOfSportBuilding deleteTypeOfSportBuilding(int id) throws SQLException;
    public List<TypeOfSportBuilding> getAll() throws SQLException;
}
