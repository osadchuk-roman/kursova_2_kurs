package osadchuk.roman.DAO.sportBuilding.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportBuilding.interfaces.ISportBuildingDAO;
import osadchuk.roman.DAO.sportBuildingSport.interfaces.ISportBuildingSportDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.tempModel.SportBuilding;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SportBuildingDAOFakeImpl implements ISportBuildingDAO {
    @Autowired
    DataStorageJDBC dataStorage;
    //DataStorageFake dataStorage;

    @Override
    public SportBuilding insertSportBuilding(SportBuilding sportBuilding) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.sport_building " +
                "(name,type_of_sport_building_id,phone,address) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        //statement.setLong(1, kindOfSport.getId());
        statement.setString(1, sportBuilding.getName());
        statement.setInt(2, (int)sportBuilding.getTypeOfSportBuildingId());
        statement.setString(3, sportBuilding.getPhone());
        statement.setString(4, sportBuilding.getAddress());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return sportBuilding;
        else
            return null;
    }

    @Override
    public SportBuilding getSportBuilding(int id) throws SQLException {
        List<SportBuilding> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage
                .executeQuery("SELECT * FROM `information system of sports organizations`.sport_building where id="+id);
        while (resultSet.next()){
            list.add(new SportBuilding(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("type_of_sport_building_id"),
                    resultSet.getString("phone"),
                    resultSet.getString("address")
            ));
        }
        return list.get(0);
    }

    @Override
    public SportBuilding updateSportBuilding(SportBuilding sportBuilding) throws SQLException {
        String sql  ="UPDATE sport_building SET sport_building.name =?, sport_building.type_of_sport_building_id =?, " +
                "sport_building.phone =?, sport_building.address =?,  WHERE sport_building.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,sportBuilding.getName());
        statement.setInt(2,(int)sportBuilding.getTypeOfSportBuildingId());
        statement.setString(3,sportBuilding.getPhone());
        statement.setString(4,sportBuilding.getAddress());
        statement.setInt(5,(int)sportBuilding.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return sportBuilding;
        else
            return null;
    }

    @Override
    public SportBuilding deleteSportBuilding(int id) throws SQLException {
        List<SportBuilding> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM `information system of sports organizations`.sport_building where id="+id);
        while (resultSet.next()){
            list.add(new SportBuilding(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("type_of_sport_building_id"),
                    resultSet.getString("phone"),
                    resultSet.getString("address")
            ));


        }
        String sql = "DELETE FROM sport_building WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        /*if (rowsDeleted > 0) {
            return kindOfSport;
        }*/
        return list.get(0);
    }

    @Override
    public List<SportBuilding> getAll() throws SQLException {
        List<SportBuilding> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM `information system of sports organizations`.sport_building");
        while (resultSet.next()){
            list.add(new SportBuilding(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("type_of_sport_building_id"),
                    resultSet.getString("phone"),
                    resultSet.getString("address")
            ));


        }
        return list;
    }


   /* @Override
    public SportBuilding insertSportBuilding(SportBuilding sportBuilding) {
        dataStorage.getSportBuilding().add(sportBuilding);
        return sportBuilding;
    }

    @Override
    public SportBuilding getSportBuilding(int id) {
        return dataStorage.getSportBuilding().get(id);
    }

    @Override
    public SportBuilding updateSportBuilding(SportBuilding sportBuilding) {
        for (SportBuilding sb : dataStorage.getSportBuilding()) {
            if(sb.getId() == sportBuilding.getId()){
                sb.setName(sportBuilding.getName());
                break;
            }
        }
        return sportBuilding;
    }

    @Override
    public SportBuilding deleteSportBuilding(int id) {
        SportBuilding sportBuilding = dataStorage.getSportBuilding()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportBuilding().indexOf(sportBuilding);
        dataStorage.getSportBuilding().remove(index);
        return sportBuilding;
    }

    @Override
    public List<SportBuilding> getAll() {
        return dataStorage.getSportBuilding();
    }*/
}
