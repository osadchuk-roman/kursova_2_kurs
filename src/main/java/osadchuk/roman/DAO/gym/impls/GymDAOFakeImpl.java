package osadchuk.roman.DAO.gym.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.gym.interfaces.IGymDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.Gym;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GymDAOFakeImpl implements IGymDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public Gym insertGym(Gym gym) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.gym " +
                "(sport_building_id,presence_of_cardio_zone,presence_of_crossfit_zone," +
                "presence_of_boxing_ring) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        //statement.setLong(1, kindOfSport.getId());
        statement.setInt(1,gym.getSportBuilding().getId());
        statement.setBoolean(2,gym.getPresenceOfCardioZone());
        statement.setBoolean(3,gym.getPresenceOfCrossfitZone());
        statement.setBoolean(4,gym.getPresenceOfCrossfitZone());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return gym;
        else
            return null;
    }

    @Override
    public Gym getGym(int id) throws SQLException {
        List<Gym> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM gym join sport_building \n" +
                        "on gym.sport_building_id = sport_building.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id = type_of_sport_building.id\n" +
                        "where gym.id="+id+" order by gym.id");
        while (resultSet.next()){
            list.add(new Gym(
                    resultSet.getInt("gym.id"),
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
                    resultSet.getBoolean("gym.presence_of_cardio_zone"),
                    resultSet.getBoolean("gym.presence_of_crossfit_zone"),
                    resultSet.getBoolean("gym.presence_of_boxing_ring")
            ));

        }
        return list.get(0);
    }

    @Override
    public Gym updateGym(Gym gym) throws SQLException {
        String sql  ="UPDATE gym SET gym.sport_building_id =?, gym.presence_of_cardio_zone =?, " +
                "gym.presence_of_crossfit_zone =?, gym.presence_of_boxing_ring =?  WHERE gym.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,gym.getSportBuilding().getId());
        statement.setBoolean(2,gym.getPresenceOfCardioZone());
        statement.setBoolean(3,gym.getPresenceOfCrossfitZone());
        statement.setBoolean(4,gym.getPresenceOfCrossfitZone());
        statement.setInt(5,gym.getId());
        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return gym;
        else
            return null;
    }

    @Override
    public Gym deleteGym(int id) throws SQLException {
        List<Gym> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM gym join sport_building \n" +
                        "on gym.sport_building_id = sport_building.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id = type_of_sport_building.id\n" +
                        "where gym.id="+id+" order by gym.id");
        while (resultSet.next()){
            list.add(new Gym(
                    resultSet.getInt("gym.id"),
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
                    resultSet.getBoolean("gym.presence_of_cardio_zone"),
                    resultSet.getBoolean("gym.presence_of_crossfit_zone"),
                    resultSet.getBoolean("gym.presence_of_boxing_ring")
            ));

        }
        String sql = "DELETE FROM gym WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        else  return null;
    }

    @Override
    public List<Gym> getAll() throws SQLException {
        List<Gym> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM gym join sport_building \n" +
                        "on gym.sport_building_id = sport_building.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id = type_of_sport_building.id\n" +
                        " order by gym.id");
        while (resultSet.next()){
            list.add(new Gym(
                    resultSet.getInt("gym.id"),
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
                    resultSet.getBoolean("gym.presence_of_cardio_zone"),
                    resultSet.getBoolean("gym.presence_of_crossfit_zone"),
                    resultSet.getBoolean("gym.presence_of_boxing_ring")
            ));

        }
        return list;
    }
    // DataStorageFake dataStorage;


    /*@Override
    public Gym insertGym(Gym gym) {
        dataStorage.getGyms().add(gym);
        return gym;
    }

    @Override
    public Gym getGym(int id) {
        return dataStorage.getGyms().get(id);
    }

    @Override
    public Gym updateGym(Gym gym) {
        for (Gym g : dataStorage.getGyms()) {
            if(g.getId() == gym.getId()){
                g.setSportBuilding(gym.getSportBuilding());
                g.setPresenceOfBoxingRing(gym.getPresenceOfBoxingRing());
                g.setPresenceOfCardioZone(gym.getPresenceOfCardioZone());
                g.setPresenceOfCrossfitZone(gym.getPresenceOfCrossfitZone());
                break;
            }
        }
        return gym;
    }

    @Override
    public Gym deleteGym(int id) {
        Gym gym = dataStorage.getGyms()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getGyms().indexOf(gym);
        dataStorage.getGyms().remove(index);
        return gym;
    }

    @Override
    public List<Gym> getAll() {
        return dataStorage.getGyms();
    }*/
}
