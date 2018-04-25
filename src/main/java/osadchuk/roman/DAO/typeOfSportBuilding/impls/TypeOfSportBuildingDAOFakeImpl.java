package osadchuk.roman.DAO.typeOfSportBuilding.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.typeOfSportBuilding.interfaces.ITypeOfSportBuildingDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TypeOfSportBuildingDAOFakeImpl implements ITypeOfSportBuildingDAO{
    @Autowired
    DataStorageJDBC dataStorage;
    //DataStorageFake dataStorage;

    @Override
    public TypeOfSportBuilding insertTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.type_of_sport_building (name) VALUES (?)";
        PreparedStatement statement;
        statement = dataStorage.getCon().prepareStatement(sql);
        //statement.setLong(1, kindOfSport.getId());
        statement.setString(1, typeOfSportBuilding.getName());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return typeOfSportBuilding;
        else
            return null;
    }

    @Override
    public TypeOfSportBuilding getTypeOfSportBuilding(int id) throws SQLException {
        List<TypeOfSportBuilding> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage
                .executeQuery("SELECT * FROM `information system of sports organizations`.type_of_sport_building where id="+id);
        while (resultSet.next()){
            list.add(new TypeOfSportBuilding(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));
        }
        return list.get(0);
    }

    @Override
    public TypeOfSportBuilding updateTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) throws SQLException {
        String sql  ="UPDATE type_of_sport_building SET type_of_sport_building.name =?  WHERE type_of_sport_building.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,typeOfSportBuilding.getName());
        statement.setInt(2,(int)typeOfSportBuilding.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return typeOfSportBuilding;
        else
            return null;
    }

    @Override
    public TypeOfSportBuilding deleteTypeOfSportBuilding(int id) throws SQLException {
        List<TypeOfSportBuilding> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM `information system of sports organizations`.type_of_sport_building where id="+id);
        while (resultSet.next()){
            list.add(new TypeOfSportBuilding(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));


        }
        String sql = "DELETE FROM type_of_sport_building WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        /*if (rowsDeleted > 0) {
            return kindOfSport;
        }*/
        return list.get(0);
    }

    @Override
    public List<TypeOfSportBuilding> getAll() throws SQLException {
        List<TypeOfSportBuilding> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM `information system of sports organizations`.type_of_sport_building");
        while (resultSet.next()){
            list.add(new TypeOfSportBuilding(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));


        }
        return list;
    }

    /*@Override
    public TypeOfSportBuilding insertTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) {
        dataStorage.getTypesOfSportBuilding().add(typeOfSportBuilding);
        return typeOfSportBuilding;
    }

    @Override
    public TypeOfSportBuilding getTypeOfSportBuilding(int id) {
        return dataStorage.getTypesOfSportBuilding().get(id);
    }

    @Override
    public TypeOfSportBuilding updateTypeOfSportBuilding(TypeOfSportBuilding typeOfSportBuilding) {
        for (TypeOfSportBuilding ts : dataStorage.getTypesOfSportBuilding()) {
            if(ts.getId() == typeOfSportBuilding.getId()){
                ts.setName(typeOfSportBuilding.getName());
                break;
            }
        }
        return typeOfSportBuilding;
    }

    @Override
    public TypeOfSportBuilding deleteTypeOfSportBuilding(int id) {
        TypeOfSportBuilding typeOfSportBuilding = dataStorage.getTypesOfSportBuilding()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getTypesOfSportBuilding().indexOf(typeOfSportBuilding);
        dataStorage.getTypesOfSportBuilding().remove(index);
        return typeOfSportBuilding;
    }

    @Override
    public List<TypeOfSportBuilding> getAll() {
        return dataStorage.getTypesOfSportBuilding();
    }*/
}
