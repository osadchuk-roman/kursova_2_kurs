package osadchuk.roman.DAO.sportsmanSportCoach.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportsmanSportCoach.interfaces.ISportsmanSportCoachDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class SportsmanSportCoachDAOFakeImpl implements ISportsmanSportCoachDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public SportsmanSportCoach insertSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.sportsman_sport_coach " +
                "(sportsman_id, kind_of_sport_id, sport_сategory_id, coach_id) VALUES (?,?,?,?)";
        PreparedStatement statement;
        statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,sportsmanSportCoach.getSportsman().getId());
        statement.setInt(2,sportsmanSportCoach.getKindOfSport().getId());
        statement.setInt(3,sportsmanSportCoach.getSportCategory().getId());
        statement.setInt(4,sportsmanSportCoach.getCoach().getId());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return sportsmanSportCoach;
        else
            return null;
    }

    @Override
    public SportsmanSportCoach getSportsmanSportCoach(int id) throws SQLException {
        List<SportsmanSportCoach> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "select * from sportsman_sport_coach join sportsman\n" +
                        "on sportsman_sport_coach.sportsman_id = sportsman.id\n" +
                        "join coach on sportsman_sport_coach.coach_id=coach.id\n" +
                        "join kind_of_sport on sportsman_sport_coach.kind_of_sport_id = kind_of_sport.id\n" +
                        "join sport_category on sportsman_sport_coach.sport_сategory_id = sport_category.id\n" +
                        "where sportsman_sport_coach.id="+id+ " order by sportsman_sport_coach.id");
        while (resultSet.next()){
            list.add(new SportsmanSportCoach(
                    resultSet.getInt("sportsman_sport_coach.id"),
                    new Sportsman(
                            resultSet.getInt("sportsman.id"),
                            resultSet.getString("sportsman.name"),
                            resultSet.getInt("sportsman.age"),
                            resultSet.getString("sportsman.gender"),
                            null
                    ),
                    new KindOfSport(
                            resultSet.getInt("kind_of_sport.id"),
                            resultSet.getString("kind_of_sport.name")
                    ),
                    new SportCategory(
                            resultSet.getInt("sport_category.id"),
                            resultSet.getString("sport_category.name")
                    ),
                    new Coach(
                            resultSet.getInt("coach.id"),
                            resultSet.getString("coach.name"),
                            null
                    )

            ));


        }
        return list.get(0);
    }

    @Override
    public SportsmanSportCoach updateSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) throws SQLException {
        String sql  ="UPDATE sportsman_sport_coach SET sportsman_sport_coach.sportsman_id =?,  " +
                "sportsman_sport_coach.kind_of_sport_id =? , sportsman_sport_coach.sport_сategory_id =? ," +
                "sportsman_sport_coach.coach_id =? WHERE sportsman_sport_coach.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,sportsmanSportCoach.getSportsman().getId());
        statement.setInt(2,sportsmanSportCoach.getKindOfSport().getId());
        statement.setInt(3,sportsmanSportCoach.getSportCategory().getId());
        statement.setInt(4,sportsmanSportCoach.getCoach().getId());
        statement.setInt(5,sportsmanSportCoach.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return sportsmanSportCoach;
        else
            return null;
    }

    @Override
    public SportsmanSportCoach deleteSportsmanSportCoach(int id) throws SQLException {
        List<SportsmanSportCoach> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "select * from sportsman_sport_coach join sportsman\n" +
                        "on sportsman_sport_coach.sportsman_id = sportsman.id\n" +
                        "join coach on sportsman_sport_coach.coach_id=coach.id\n" +
                        "join kind_of_sport on sportsman_sport_coach.kind_of_sport_id = kind_of_sport.id\n" +
                        "join sport_category on sportsman_sport_coach.sport_сategory_id = sport_category.id\n" +
                        "where sportsman_sport_coach.id="+id+ " order by sportsman_sport_coach.id");
        while (resultSet.next()){
            list.add(new SportsmanSportCoach(
                    resultSet.getInt("sportsman_sport_coach.id"),
                    new Sportsman(
                            resultSet.getInt("sportsman.id"),
                            resultSet.getString("sportsman.name"),
                            resultSet.getInt("sportsman.age"),
                            resultSet.getString("sportsman.gender"),
                            null
                    ),
                    new KindOfSport(
                            resultSet.getInt("kind_of_sport.id"),
                            resultSet.getString("kind_of_sport.name")
                    ),
                    new SportCategory(
                            resultSet.getInt("sport_category.id"),
                            resultSet.getString("sport_category.name")
                    ),
                    new Coach(
                            resultSet.getInt("coach.id"),
                            resultSet.getString("coach.name"),
                            null
                    )

            ));

        }
        String sql = "DELETE FROM sportsman_sport_coach WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();
        return list.get(0);
    }

    @Override
    public List<SportsmanSportCoach> getAll() throws SQLException {
        List<SportsmanSportCoach> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "select * from sportsman_sport_coach join sportsman\n" +
                        "on sportsman_sport_coach.sportsman_id = sportsman.id\n" +
                        "join coach on sportsman_sport_coach.coach_id=coach.id\n" +
                        "join kind_of_sport on sportsman_sport_coach.kind_of_sport_id = kind_of_sport.id\n" +
                        "join sport_category on sportsman_sport_coach.sport_сategory_id = sport_category.id\n" +
                        "order by sportsman_sport_coach.id");
        while (resultSet.next()){
            list.add(new SportsmanSportCoach(
                    resultSet.getInt("sportsman_sport_coach.id"),
                    new Sportsman(
                            resultSet.getInt("sportsman.id"),
                            resultSet.getString("sportsman.name"),
                            resultSet.getInt("sportsman.age"),
                            resultSet.getString("sportsman.gender"),
                            null
                    ),
                    new KindOfSport(
                            resultSet.getInt("kind_of_sport.id"),
                            resultSet.getString("kind_of_sport.name")
                    ),
                    new SportCategory(
                    resultSet.getInt("sport_category.id"),
                    resultSet.getString("sport_category.name")
                    ),
                    new Coach(
                            resultSet.getInt("coach.id"),
                            resultSet.getString("coach.name"),
                            null
                    )

            ));

        }
        return list;
    }
    // DataStorageFake dataStorage;
    /*@Override
    public SportsmanSportCoach insertSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) {
        dataStorage.getSportsmanSportCoaches().add(sportsmanSportCoach);
        return sportsmanSportCoach;
    }

    @Override
    public SportsmanSportCoach getSportsmanSportCoach(int id) {
        return dataStorage.getSportsmanSportCoaches().get(id);
    }

    @Override
    public SportsmanSportCoach updateSportsmanSportCoach(SportsmanSportCoach sportsmanSportCoach) {
        for (SportsmanSportCoach sportsmanSportCoach1 : dataStorage.getSportsmanSportCoaches()) {
            if(sportsmanSportCoach1.getId() == sportsmanSportCoach.getId()){
                sportsmanSportCoach1.setKindOfSport(sportsmanSportCoach.getKindOfSport());
                sportsmanSportCoach1.setCoach(sportsmanSportCoach.getCoach());
                sportsmanSportCoach1.setSportCategory(sportsmanSportCoach.getSportCategory());
                sportsmanSportCoach1.setSportsman(sportsmanSportCoach.getSportsman());
                break;
            }
        }
        return sportsmanSportCoach;
    }

    @Override
    public SportsmanSportCoach deleteSportsmanSportCoach(int id) {
        SportsmanSportCoach sportsmanSportCoach = dataStorage.getSportsmanSportCoaches()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportsmanSportCoaches().indexOf(sportsmanSportCoach);
        dataStorage.getSportsmanSportCoaches().remove(index);
        return sportsmanSportCoach;
    }

    @Override
    public List<SportsmanSportCoach> getAll() {
        return dataStorage.getSportsmanSportCoaches();
    }*/
}
