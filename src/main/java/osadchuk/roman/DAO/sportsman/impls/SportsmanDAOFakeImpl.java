package osadchuk.roman.DAO.sportsman.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportsman.interfaces.ISportsmanDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.SportClub;
import osadchuk.roman.model.Sportsman;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SportsmanDAOFakeImpl implements ISportsmanDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public Sportsman insertSportsman(Sportsman sportsman) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.sportsman " +
                "(name,age,gender,sport_club_id) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        //statement.setLong(1, kindOfSport.getId());
        statement.setString(1, sportsman.getName());
        statement.setInt(2, sportsman.getAge());
        statement.setString(3, sportsman.getGender());
        statement.setInt(4, sportsman.getSportClub().getId());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return sportsman;
        else
            return null;
    }

    @Override
    public Sportsman getSportsman(int id) throws SQLException {
        List<Sportsman> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM sportsman join sport_club \n" +
                        "on sportsman.sport_club_id = sport_club.id\n" +
                        "where sportsman.id="+id+" order by sportsman.id");
        while (resultSet.next()){
            list.add(new Sportsman(
                    resultSet.getInt("sportsman.id"),
                    resultSet.getString("sportsman.name"),
                    resultSet.getInt("sportsman.age"),
                    resultSet.getString("sportsman.gender"),
                    new SportClub(
                            resultSet.getInt("sport_club.id"),
                            resultSet.getString("sport_club.name"),
                            resultSet.getString("sport_club.admin_name"),
                            resultSet.getString("sport_club.phone"),
                            resultSet.getString("sport_club.address")
                    )

            ));

        }
        return list.get(0);
    }

    @Override
    public Sportsman updateSportsman(Sportsman sportsman) throws SQLException {
        String sql  ="UPDATE sportsman SET sportsman.name =?, sportsman.age =?, " +
                " sportsman.gender =?, sportsman.sport_club_id =? WHERE sportsman.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,sportsman.getName());
        statement.setInt(2,sportsman.getAge());
        statement.setString(3,sportsman.getGender());
        statement.setInt(4,sportsman.getSportClub().getId());
        statement.setInt(5,(int)sportsman.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return sportsman;
        else
            return null;
    }

    @Override
    public Sportsman deleteSportsman(int id) throws SQLException {
        List<Sportsman> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                        "SELECT * FROM sportsman join sport_club \n" +
                        "on sportsman.sport_club_id = sport_club.id\n" +
                        "where sportsman.id="+id+" order by sportsman.id");
        while (resultSet.next()){
            list.add(new Sportsman(
                    resultSet.getInt("sportsman.id"),
                    resultSet.getString("sportsman.name"),
                    resultSet.getInt("sportsman.age"),
                    resultSet.getString("sportsman.gender"),
                    new SportClub(
                            resultSet.getInt("sport_club.id"),
                            resultSet.getString("sport_club.name"),
                            resultSet.getString("sport_club.admin_name"),
                            resultSet.getString("sport_club.phone"),
                            resultSet.getString("sport_club.address")
                    )

            ));
        }
        String sql = "DELETE FROM sportsman WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        else  return null;
    }

    @Override
    public List<Sportsman> getAll() throws SQLException {
        List<Sportsman> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM sportsman join sport_club \n" +
                "on sportsman.sport_club_id = sport_club.id\n" +
                "order by sportsman.id");
        while (resultSet.next()){
            list.add(new Sportsman(
                    resultSet.getInt("sportsman.id"),
                    resultSet.getString("sportsman.name"),
                    resultSet.getInt("sportsman.age"),
                    resultSet.getString("sportsman.gender"),
                    new SportClub(
                            resultSet.getInt("sport_club.id"),
                            resultSet.getString("sport_club.name"),
                            resultSet.getString("sport_club.admin_name"),
                            resultSet.getString("sport_club.phone"),
                            resultSet.getString("sport_club.address")
                    )

            ));

        }
        return list;
    }
    //DataStorageFake dataStorage;

    /*@Override
    public Sportsman insertSportsman(Sportsman sportsman) {
        dataStorage.getSportsmen().add(sportsman);
        return sportsman;
    }

    @Override
    public Sportsman getSportsman(int id) {
        return dataStorage.getSportsmen().get(id);
    }

    @Override
    public Sportsman updateSportsman(Sportsman sportsman) {
        for (Sportsman s : dataStorage.getSportsmen()) {
            if(s.getId() == sportsman.getId()){
                s.setName(sportsman.getName());
                s.setAge(sportsman.getAge());
                s.setGender(sportsman.getGender());
                s.setSportClub(sportsman.getSportClub());
                break;
            }
        }
        return sportsman;
    }

    @Override
    public Sportsman deleteSportsman(int id) {
        Sportsman sportsman = dataStorage.getSportsmen()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportsmen().indexOf(sportsman);
        dataStorage.getSportsmen().remove(index);
        return sportsman;
    }

    @Override
    public List<Sportsman> getAll() {
        return dataStorage.getSportsmen();
    }*/
}
