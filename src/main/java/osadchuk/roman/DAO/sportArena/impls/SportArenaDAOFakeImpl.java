package osadchuk.roman.DAO.sportArena.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import osadchuk.roman.DAO.sportArena.interfaces.ISportArenaDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.SportArena;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SportArenaDAOFakeImpl implements ISportArenaDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public SportArena insertSportArena(SportArena sportArena) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.sport_arena " +
                "(sport_building_id, capacity, presence_of_gymnastic_zone, " +
                "presence_of_boxing_ring, presence_of_matirial_arts_zone)  VALUES (?,?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,sportArena.getSportBuilding().getId());
        statement.setInt(2,sportArena.getCapacity());
        statement.setBoolean(3,sportArena.getPresenceOfGymnasticZone());
        statement.setBoolean(4,sportArena.getPresenceOfBoxingRing());
        statement.setBoolean(5,sportArena.getPresenceOfMatirialArtsZone());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return sportArena;
        else
            return null;
    }

    @Override
    public SportArena getSportArena(int id) throws SQLException {
        List<SportArena> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM sport_arena join sport_building\n" +
                        "on sport_arena.sport_building_id=sport_building.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id=type_of_sport_building.id\n" +
                        "where sport_arena.id="+id+" order by sport_arena.id"
        );
        while (resultSet.next()){
            list.add(new SportArena(
                    resultSet.getInt("sport_arena.id"),
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
                    resultSet.getInt("sport_arena.capacity"),
                    resultSet.getBoolean("sport_arena.presence_of_gymnastic_zone"),
                    resultSet.getBoolean("sport_arena.presence_of_boxing_ring"),
                    resultSet.getBoolean("sport_arena.presence_of_matirial_arts_zone")
            ));

        }
        return list.get(0);
    }

    @Override
    public SportArena updateSportArena(SportArena sportArena) throws SQLException {
        String sql  ="UPDATE sport_arena SET sport_arena.sport_building_id =?, sport_arena.capacity=?, " +
                "sport_arena.presence_of_gymnastic_zone=?,sport_arena.presence_of_boxing_ring=?," +
                "sport_arena.presence_of_matirial_arts_zone=? WHERE sport_arena.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,sportArena.getSportBuilding().getId());
        statement.setInt(2,sportArena.getCapacity());
        statement.setBoolean(3,sportArena.getPresenceOfGymnasticZone());
        statement.setBoolean(4,sportArena.getPresenceOfBoxingRing());
        statement.setBoolean(5,sportArena.getPresenceOfMatirialArtsZone());
        statement.setInt(6,sportArena.getId());
        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return sportArena;
        else
            return null;
    }

    @Override
    public SportArena deleteSportArena(int id) throws SQLException {
        List<SportArena> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM sport_arena join sport_building\n" +
                        "on sport_arena.sport_building_id=sport_building.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id=type_of_sport_building.id\n" +
                        "where sport_arena.id="+id+" order by sport_arena.id"
        );
        while (resultSet.next()){
            list.add(new SportArena(
                    resultSet.getInt("sport_arena.id"),
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
                    resultSet.getInt("sport_arena.capacity"),
                    resultSet.getBoolean("sport_arena.presence_of_gymnastic_zone"),
                    resultSet.getBoolean("sport_arena.presence_of_boxing_ring"),
                    resultSet.getBoolean("sport_arena.presence_of_matirial_arts_zone")
            ));

        }
        String sql = "DELETE FROM sport_arena WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        else  return null;
    }

    @Override
    public List<SportArena> getAll() throws SQLException {
        List<SportArena> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM sport_arena join sport_building\n" +
                        "on sport_arena.sport_building_id=sport_building.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id=type_of_sport_building.id\n" +
                        "order by sport_arena.id"
        );
        while (resultSet.next()){
            list.add(new SportArena(
                    resultSet.getInt("sport_arena.id"),
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
                    resultSet.getInt("sport_arena.capacity"),
                    resultSet.getBoolean("sport_arena.presence_of_gymnastic_zone"),
                    resultSet.getBoolean("sport_arena.presence_of_boxing_ring"),
                    resultSet.getBoolean("sport_arena.presence_of_matirial_arts_zone")
            ));

        }
        return list;
    }
    //DataStorageFake dataStorage;

    /*@Override
    public SportArena insertSportArena(SportArena sportArena) {
        dataStorage.getSportArena().add(sportArena);
        return sportArena;
    }

    @Override
    public SportArena getSportArena(int id) {
        return dataStorage.getSportArena().get(id);
    }

    @Override
    public SportArena updateSportArena(SportArena sportArena) {
        for (SportArena s : dataStorage.getSportArena()) {
            if(s.getId() == sportArena.getId()){
                s.setSportBuilding(sportArena.getSportBuilding());
                s.setCapacity(sportArena.getCapacity());
                s.setPresenceOfGymnasticZone(sportArena.getPresenceOfGymnasticZone());
                s.setPresenceOfBoxingRing(sportArena.getPresenceOfBoxingRing());
                s.setPresenceOfMatirialArtsZone(sportArena.getPresenceOfMatirialArtsZone());
            }
        }
        return sportArena;
    }

    @Override
    public SportArena deleteSportArena(int id) {
        SportArena sportArena = dataStorage.getSportArena()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportArena().indexOf(sportArena);
        dataStorage.getSportArena().remove(index);
        return sportArena;
    }

    @Override
    public List<SportArena> getAll() {
        return dataStorage.getSportArena();
    }*/
}
