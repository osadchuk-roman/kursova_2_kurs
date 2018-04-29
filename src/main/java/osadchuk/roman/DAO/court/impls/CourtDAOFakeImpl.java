package osadchuk.roman.DAO.court.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.court.interfaces.ICourtDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.Court;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.TypeOfCover;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourtDAOFakeImpl implements ICourtDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public Court insertCourt(Court court) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.court " +
                "(sport_building_id, type_of_cover_id, width, length) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,court.getSportBuilding().getId());
        statement.setInt(2,court.getTypeOfCover().getId());
        statement.setDouble(3,court.getWidth());
        statement.setDouble(4,court.getLength());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return court;
        else
            return null;
    }

    @Override
    public Court getCourt(int id) throws SQLException {
        List<Court> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM court join sport_building\n" +
                        "on court.sport_building_id=sport_building.id\n" +
                        "join type_of_cover\n" +
                        "on court.type_of_cover_id=type_of_cover.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id=type_of_sport_building.id\n" +
                        "where court.id ="+id+" order by court.id"
        );
        while (resultSet.next()){
            list.add(new Court(
                    resultSet.getInt("court.id"),
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
                    new TypeOfCover(
                            resultSet.getInt("type_of_cover.id"),
                            resultSet.getString("type_of_cover.name")
                    ),
                    resultSet.getDouble("court.width"),
                    resultSet.getDouble("court.length")
            ));

        }
        return list.get(0);
    }

    @Override
    public Court updateCourt(Court court) throws SQLException {
        String sql  ="UPDATE court SET court.sport_building_id =?, court.type_of_cover_id=?, " +
                "court.width=?,court.length=? WHERE court.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,court.getSportBuilding().getId());
        statement.setInt(2,court.getTypeOfCover().getId());
        statement.setDouble(3,court.getWidth());
        statement.setDouble(4,court.getLength());
        statement.setInt(5,court.getId());
        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return court;
        else
            return null;
    }

    @Override
    public Court deleteCourt(int id) throws SQLException {
        List<Court> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM court join sport_building\n" +
                        "on court.sport_building_id=sport_building.id\n" +
                        "join type_of_cover\n" +
                        "on court.type_of_cover_id=type_of_cover.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id=type_of_sport_building.id\n" +
                        "where court.id ="+id+" order by court.id"
        );
        while (resultSet.next()){
            list.add(new Court(
                    resultSet.getInt("court.id"),
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
                    new TypeOfCover(
                            resultSet.getInt("type_of_cover.id"),
                            resultSet.getString("type_of_cover.name")
                    ),
                    resultSet.getDouble("court.width"),
                    resultSet.getDouble("court.length")
            ));

        }
        String sql = "DELETE FROM court WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        else  return null;
    }

    @Override
    public List<Court> getAll() throws SQLException {
        List<Court> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM court join sport_building\n" +
                        "on court.sport_building_id=sport_building.id\n" +
                        "join type_of_cover\n" +
                        "on court.type_of_cover_id=type_of_cover.id\n" +
                        "join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id=type_of_sport_building.id\n" +
                        "order by court.id"
        );
        while (resultSet.next()){
            list.add(new Court(
                    resultSet.getInt("court.id"),
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
                    new TypeOfCover(
                            resultSet.getInt("type_of_cover.id"),
                            resultSet.getString("type_of_cover.name")
                    ),
                    resultSet.getDouble("court.width"),
                    resultSet.getDouble("court.length")
            ));

        }
        return list;
    }
    //DataStorageFake dataStorage;

    /*@Override
    public Court insertCourt(Court court) {
        dataStorage.getCourts().add(court);
        return court;
    }

    @Override
    public Court getCourt(int id) {
        return dataStorage.getCourts().get(id);
    }

    @Override
    public Court updateCourt(Court court) {
        for (Court c : dataStorage.getCourts()) {
            if(c.getId() == court.getId()){
                c.setSportBuilding(court.getSportBuilding());
                c.setTypeOfCover(court.getTypeOfCover());
                c.setLength(court.getLength());
                c.setWidth(court.getWidth());
                break;
            }
        }
        return court;
    }

    @Override
    public Court deleteCourt(int id) {
        Court court = dataStorage.getCourts()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getCourts().indexOf(court);
        dataStorage.getCourts().remove(index);
        return court;
    }

    @Override
    public List<Court> getAll() {
        return dataStorage.getCourts();
    }*/
}
