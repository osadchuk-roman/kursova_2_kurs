package osadchuk.roman.DAO.coach.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.coach.interfaces.ICoachDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.Coach;
import osadchuk.roman.model.SportClub;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CoachDAOFakeImpl implements ICoachDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public Coach insertCoach(Coach coach) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.coach " +
                "(name,sport_club_id) VALUES (?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setString(1, coach.getName());
        statement.setInt(2, coach.getSportClub().getId());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return coach;
        else
            return null;
    }

    @Override
    public Coach getCoach(int id) throws SQLException {
        List<Coach> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "select * from coach join sport_club\n" +
                        "on coach.sport_club_id = sport_club.id\n" +
                        "where coach.id="+id+" order by coach.id");
        while (resultSet.next()){
            list.add(new Coach(
                    resultSet.getInt("coach.id"),
                    resultSet.getString("coach.name"),
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
    public Coach updateCoach(Coach coach) throws SQLException {
        String sql  ="UPDATE coach SET coach.name =?, coach.sport_club_id =? WHERE coach.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,coach.getName());
        statement.setInt(2,coach.getSportClub().getId());
        statement.setInt(3,coach.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return coach;
        else
            return null;
    }

    @Override
    public Coach deleteCoach(int id) throws SQLException {
        List<Coach> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "select * from coach join sport_club\n" +
                        "on coach.sport_club_id = sport_club.id\n" +
                        "where coach.id="+id+" order by coach.id");
        while (resultSet.next()){
            list.add(new Coach(
                    resultSet.getInt("coach.id"),
                    resultSet.getString("coach.name"),
                    new SportClub(
                            resultSet.getInt("sport_club.id"),
                            resultSet.getString("sport_club.name"),
                            resultSet.getString("sport_club.admin_name"),
                            resultSet.getString("sport_club.phone"),
                            resultSet.getString("sport_club.address")
                    )

            ));

        }
        String sql = "DELETE FROM coach WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        else  return null;
    }

    @Override
    public List<Coach> getAll() throws SQLException {
        List<Coach> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "select * from coach join sport_club\n" +
                        "on coach.sport_club_id = sport_club.id\n" +
                        "order by coach.id");
        while (resultSet.next()){
            list.add(new Coach(
                    resultSet.getInt("coach.id"),
                    resultSet.getString("coach.name"),
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
    public Coach insertCoach(Coach coach) {
        dataStorage.getCoaches().add(coach);
        return coach;
    }

    @Override
    public Coach getCoach(int id) {
        return dataStorage.getCoaches().get(id);
    }

    @Override
    public Coach updateCoach(Coach coach) {
        for (Coach c : dataStorage.getCoaches()) {
            if(c.getId() == coach.getId()){
                c.setName(coach.getName());
                c.setSportClub(coach.getSportClub());
                break;
            }
        }
        return coach;
    }

    @Override
    public Coach deleteCoach(int id) {
        Coach coach = dataStorage.getCoaches()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getCoaches().indexOf(coach);
        dataStorage.getCoaches().remove(index);
        return coach;
    }

    @Override
    public List<Coach> getAll() {
        return dataStorage.getCoaches();
    }*/
}
