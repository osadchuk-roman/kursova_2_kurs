package osadchuk.roman.DAO.stadium.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.stadium.interfaces.IStadiumDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.Stadium;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StadiumDAOFakeImpl implements IStadiumDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public Stadium insertStadium(Stadium stadium) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.stadium " +
                "(sport_building_id,capaciity,field_area," +
                "presence_of_path_for_runnig,presence_of_gymnastic_zone) VALUES (?,?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,stadium.getSportBuilding().getId());
        statement.setInt(2,stadium.getCapacity());
        statement.setDouble(3,stadium.getFieldArea());
        statement.setBoolean(4,stadium.getPresenceOfPathForRunning());
        statement.setBoolean(5,stadium.getPresenceOfGymnasticZone());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return stadium;
        else
            return null;
    }

    @Override
    public Stadium getStadium(int id) throws SQLException {
        List<Stadium> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "select * from stadium join sport_building\n" +
                        "on stadium.sport_building_id = sport_building.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id = type_of_sport_building.id\n" +
                        "where stadium.id ="+id+" order by stadium.id");
        while (resultSet.next()){
            list.add(new Stadium(
                    resultSet.getInt("stadium.id"),
                    new SportBuilding(
                            resultSet.getInt("sport_building.id"),
                            resultSet.getString("sport_building.name"),
                            new TypeOfSportBuilding(
                                    resultSet.getInt("type_of_sport_building.id"),
                                    resultSet.getString("type_of_sport_building.name")
                            ),
                            resultSet.getString("sport_building.phone"),
                            resultSet.getString("sport_building.address")

                    ),
                    resultSet.getInt("stadium.capaciity"),
                    resultSet.getDouble("stadium.field_area"),
                    resultSet.getBoolean("stadium.presence_of_path_for_runnig"),
                    resultSet.getBoolean("stadium.presence_of_gymnastic_zone")
            ));

        }
        return list.get(0);
    }

    @Override
    public Stadium updateStadium(Stadium stadium) throws SQLException {
        String sql  ="UPDATE stadium SET stadium.sport_building_id =?, stadium.capaciity =?, stadium.field_area =?, " +
                "stadium.presence_of_path_for_runnig =?, stadium.presence_of_gymnastic_zone =?  WHERE stadium.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,stadium.getSportBuilding().getId());
        statement.setInt(2,stadium.getCapacity());
        statement.setDouble(3,stadium.getFieldArea());
        statement.setBoolean(4,stadium.getPresenceOfPathForRunning());
        statement.setBoolean(5,stadium.getPresenceOfGymnasticZone());
        statement.setInt(6,stadium.getId());
        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return stadium;
        else
            return null;
    }

    @Override
    public Stadium deleteStadium(int id) throws SQLException {
        List<Stadium> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "select * from stadium join sport_building\n" +
                        "on stadium.sport_building_id = sport_building.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id = type_of_sport_building.id\n" +
                        "where stadium.id ="+id+" order by stadium.id");
        while (resultSet.next()){
            list.add(new Stadium(
                    resultSet.getInt("stadium.id"),
                    new SportBuilding(
                            resultSet.getInt("sport_building.id"),
                            resultSet.getString("sport_building.name"),
                            new TypeOfSportBuilding(
                                    resultSet.getInt("type_of_sport_building.id"),
                                    resultSet.getString("type_of_sport_building.name")
                            ),
                            resultSet.getString("sport_building.phone"),
                            resultSet.getString("sport_building.address")

                    ),
                    resultSet.getInt("stadium.capaciity"),
                    resultSet.getDouble("stadium.field_area"),
                    resultSet.getBoolean("stadium.presence_of_path_for_runnig"),
                    resultSet.getBoolean("stadium.presence_of_gymnastic_zone")
            ));

        }
        String sql = "DELETE FROM stadium WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        else  return null;
    }

    @Override
    public List<Stadium> getAll() throws SQLException {
        List<Stadium> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "select * from stadium join sport_building\n" +
                        "on stadium.sport_building_id = sport_building.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id = type_of_sport_building.id\n" +
                        "order by stadium.id");
        while (resultSet.next()){
            list.add(new Stadium(
                    resultSet.getInt("stadium.id"),
                    new SportBuilding(
                            resultSet.getInt("sport_building.id"),
                            resultSet.getString("sport_building.name"),
                            new TypeOfSportBuilding(
                                    resultSet.getInt("type_of_sport_building.id"),
                                    resultSet.getString("type_of_sport_building.name")
                            ),
                            resultSet.getString("sport_building.phone"),
                            resultSet.getString("sport_building.address")

                    ),
                    resultSet.getInt("stadium.capaciity"),
                    resultSet.getDouble("stadium.field_area"),
                    resultSet.getBoolean("stadium.presence_of_path_for_runnig"),
                    resultSet.getBoolean("stadium.presence_of_gymnastic_zone")
            ));

        }
        return list;
    }
    //DataStorageFake dataStorage;

   /* @Override
    public Stadium insertStadium(Stadium stadium) {
        dataStorage.getStadiums().add(stadium);
        return stadium;
    }

    @Override
    public Stadium getStadium(int id) {
        return dataStorage.getStadiums().get(id);
    }

    @Override
    public Stadium updateStadium(Stadium stadium) {
        for (Stadium s : dataStorage.getStadiums()) {
            if(s.getId() == stadium.getId()){
                s.setSportBuilding(stadium.getSportBuilding());
                s.setCapacity(stadium.getCapacity());
                s.setFieldArea(stadium.getFieldArea());
                s.setPresenceOfGymnasticZone(stadium.getPresenceOfGymnasticZone());
                s.setPresenceOfPathForRunning(stadium.getPresenceOfPathForRunning());
            }
        }
        return stadium;
    }

    @Override
    public Stadium deleteStadium(int id) {
        Stadium stadium = dataStorage.getStadiums()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getStadiums().indexOf(stadium);
        dataStorage.getStadiums().remove(index);
        return stadium;
    }

    @Override
    public List<Stadium> getAll() {
        return dataStorage.getStadiums();
    }*/
}
