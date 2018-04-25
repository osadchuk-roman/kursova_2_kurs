package osadchuk.roman.DAO.sportClub.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportClub.interfaces.ISportClubDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.Organizer;
import osadchuk.roman.model.SportClub;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SportClubDAOFakeImpl implements ISportClubDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public SportClub insertSportClub(SportClub sportClub) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.sport_club" +
                " (name,admin_name,phone,address) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        //statement.setLong(1, kindOfSport.getId());
        statement.setString(1,sportClub.getName());
        statement.setString(2,sportClub.getAdminName());
        statement.setString(3,sportClub.getPhone());
        statement.setString(4,sportClub.getAddress());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return sportClub;
        else
            return null;
    }

    @Override
    public SportClub getSportClub(int id) throws SQLException {
        List<SportClub> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage
                .executeQuery("SELECT * FROM `information system of sports organizations`.sport_club where id="+id);
        while (resultSet.next()){
            list.add(new SportClub(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("admin_name"),
                    resultSet.getString("phone"),
                    resultSet.getString("address")
            ));
        }
        return list.get(0);
    }

    @Override
    public SportClub updateSportClub(SportClub sportClub) throws SQLException {
        String sql  ="UPDATE sport_club SET sport_club.name =?, sport_club.admin_name =?, " +
                "sport_club.phone =?, sport_club.address =?  WHERE sport_club.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,sportClub.getName());
        statement.setString(2,sportClub.getAdminName());
        statement.setString(3,sportClub.getPhone());
        statement.setString(4,sportClub.getAddress());
        statement.setInt(5,(int)sportClub.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return sportClub;
        else
            return null;
    }

    @Override
    public SportClub deleteSportClub(int id) throws SQLException {
        List<SportClub> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM `information system of sports organizations`.sport_club where id="+id);
        while (resultSet.next()){
            list.add(new SportClub(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("admin_name"),
                    resultSet.getString("phone"),
                    resultSet.getString("address")
            ));


        }
        String sql = "DELETE FROM sport_club WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        /*if (rowsDeleted > 0) {
            return kindOfSport;
        }*/
        return list.get(0);
    }

    @Override
    public List<SportClub> getAll() throws SQLException {
        List<SportClub> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM `information system of sports organizations`.sport_club");
        while (resultSet.next()){
            list.add(new SportClub(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("admin_name"),
                    resultSet.getString("phone"),
                    resultSet.getString("address")
            ));


        }
        return list;
    }
    //DataStorageFake dataStorage;

    /*@Override
    public SportClub insertSportClub(SportClub sportClub) {
        dataStorage.getSportClubs().add(sportClub);
        return sportClub;
    }

    @Override
    public SportClub getSportClub(int id) {
        return dataStorage.getSportClubs().get(id);
    }

    @Override
    public SportClub updateSportClub(SportClub sportClub) {
        for (SportClub sc : dataStorage.getSportClubs()) {
            if(sc.getId() == sportClub.getId()){
                sc.setName(sportClub.getName());
                sc.setAdminName(sportClub.getAdminName());
                sc.setPhone(sportClub.getPhone());
                sc.setAddress(sportClub.getAddress());
                break;
            }
        }
        return sportClub;
    }

    @Override
    public SportClub deleteSportClub(int id) {
        SportClub sportClub = dataStorage.getSportClubs()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportClubs().indexOf(sportClub);
        dataStorage.getSportClubs().remove(index);
        return sportClub;
    }

    @Override
    public List<SportClub> getAll() {
        return dataStorage.getSportClubs();
    }*/
}
