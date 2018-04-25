package osadchuk.roman.DAO.typeOfCover.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.typeOfCover.interfaces.ITypeOfCoverDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.model.TypeOfCover;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TypeOfCoverDAOFakeImpl implements ITypeOfCoverDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public TypeOfCover insertTypeOfCover(TypeOfCover typeOfCover) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.type_of_cover (name) VALUES (?)";
        PreparedStatement statement;
        statement = dataStorage.getCon().prepareStatement(sql);
        statement.setString(1, typeOfCover.getName());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return typeOfCover;
        else
            return null;
    }

    @Override
    public TypeOfCover getTypeOfCover(int id) throws SQLException {
        List<TypeOfCover> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage
                .executeQuery("SELECT * FROM `information system of sports organizations`.type_of_cover where id="+id);
        while (resultSet.next()){
            list.add(new TypeOfCover(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));
        }
        return list.get(0);
    }

    @Override
    public TypeOfCover updateTypeOfCover(TypeOfCover typeOfCover) throws SQLException {
        String sql  ="UPDATE type_of_cover SET type_of_cover.name =?  WHERE type_of_cover.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,typeOfCover.getName());
        statement.setInt(2,(int)typeOfCover.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return typeOfCover;
        else
            return null;
    }

    @Override
    public TypeOfCover deleteTypeOfCover(int id) throws SQLException {
        List<TypeOfCover> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM `information system of sports organizations`.type_of_cover where id="+id);
        while (resultSet.next()){
            list.add(new TypeOfCover(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));


        }
        String sql = "DELETE FROM type_of_cover WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        /*if (rowsDeleted > 0) {
            return kindOfSport;
        }*/
        return list.get(0);
    }

    @Override
    public List<TypeOfCover> getAll() throws SQLException {
        List<TypeOfCover> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM `information system of sports organizations`.type_of_cover");
        while (resultSet.next()){
            list.add(new TypeOfCover(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));


        }
        return list;
    }
    //DataStorageFake dataStorage;

    /*@Override
    public TypeOfCover insertTypeOfCover(TypeOfCover typeOfCover) {
        dataStorage.getTypesOfCover().add(typeOfCover);
        return typeOfCover;
    }

    @Override
    public TypeOfCover getTypeOfCover(int id) {
        return dataStorage.getTypesOfCover().get(id);
    }

    @Override
    public TypeOfCover updateTypeOfCover(TypeOfCover typeOfCover) {
        for (TypeOfCover tc : dataStorage.getTypesOfCover()) {
            if(tc.getId() == typeOfCover.getId()){
                tc.setName(typeOfCover.getName());
                break;
            }
        }
        return typeOfCover;
    }

    @Override
    public TypeOfCover deleteTypeOfCover(int id) {
        TypeOfCover typeOfCover = dataStorage.getTypesOfCover()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getTypesOfCover().indexOf(typeOfCover);
        dataStorage.getTypesOfCover().remove(index);
        return typeOfCover;
    }

    @Override
    public List<TypeOfCover> getAll() {
        return dataStorage.getTypesOfCover();
    }*/
}
