package osadchuk.roman.DAO.sportsmanCompetition.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportsmanCompetition.interfaces.ISportsmanCompetitionDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class SportsmanCompetitionDAOFakeImpl implements ISportsmanCompetitionDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public SportsmanCompetition insertSportsmanCompetition(SportsmanCompetition sportsmanCompetition) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.sportsman_competition" +
                " (sportsman_id, Competition_id, prize_place) VALUES (?,?,?)";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,sportsmanCompetition.getSportsman().getId());
        statement.setInt(2,sportsmanCompetition.getCompetition().getId());
        statement.setInt(3,sportsmanCompetition.getPrizePlace());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return sportsmanCompetition;
        else
            return null;
    }

    @Override
    public SportsmanCompetition getSportsmanCompetition(int id) throws SQLException {
        List<SportsmanCompetition> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM sportsman_competition join sportsman\n" +
                "on sportsman_competition.sportsman_id=sportsman.id\n" +
                "join competition \n" +
                "on sportsman_competition.competition_id=competition.id\n" +
                "where sportsman_competition.id="+id+" order by sportsman_competition.id");
        while (resultSet.next()){
            list.add(new SportsmanCompetition(
                            resultSet.getInt("sportsman_competition.id"),
                            new Sportsman(
                                    resultSet.getInt("sportsman.id"),
                                    resultSet.getString("sportsman.name"),
                                    resultSet.getInt("sportsman.age"),
                                    resultSet.getString("sportsman.gender"),
                                    new SportClub(
                                            resultSet.getInt("sportsman.sport_club_id"),
                                            null,null,null,null
                                    )

                            ),
                            new Competition(
                                    resultSet.getInt("competition.id"),
                                    resultSet.getString("competition.name"),
                                    resultSet.getDate("competition.date"),
                                    new Organizer(
                                            resultSet.getInt("competition.organizer_id"),
                                            null,null,null,null
                                    ),
                                    new SportBuilding(
                                            resultSet.getInt("competition.sport_building_id"),
                                            null,null,null,null

                                    ),
                                    new KindOfSport(
                                            resultSet.getInt("competition.kind_of_sport_id"),
                                            null
                                    )
                            ),
                            resultSet.getInt("sportsman_competition.prize_place")
                    )

            );
        }
        return list.get(0);
    }

    @Override
    public SportsmanCompetition updateSportsmanCompetition(SportsmanCompetition sportsmanCompetition) throws SQLException {
        String sql  ="UPDATE sportsman_competition SET sportsman_competition.sportsman_id =?, " +
                "sportsman_competition.Competition_id =?,sportsman_competition.prize_place =? " +
                "WHERE sportsman_competition.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,sportsmanCompetition.getSportsman().getId());
        statement.setInt(2,sportsmanCompetition.getCompetition().getId());
        statement.setInt(3,sportsmanCompetition.getPrizePlace());
        statement.setInt(4,sportsmanCompetition.getId());
        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return sportsmanCompetition;
        else
            return null;
    }

    @Override
    public SportsmanCompetition deleteSportsmanCompetition(int id) throws SQLException {
        List<SportsmanCompetition> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM sportsman_competition join sportsman\n" +
                "on sportsman_competition.sportsman_id=sportsman.id\n" +
                "join competition \n" +
                "on sportsman_competition.competition_id=competition.id\n" +
                "where sportsman_competition.id="+id+" order by sportsman_competition.id");
        while (resultSet.next()){
            list.add(new SportsmanCompetition(
                            resultSet.getInt("sportsman_competition.id"),
                            new Sportsman(
                                    resultSet.getInt("sportsman.id"),
                                    resultSet.getString("sportsman.name"),
                                    resultSet.getInt("sportsman.age"),
                                    resultSet.getString("sportsman.gender"),
                                    new SportClub(
                                            resultSet.getInt("sportsman.sport_club_id"),
                                            null,null,null,null
                                    )

                            ),
                            new Competition(
                                    resultSet.getInt("competition.id"),
                                    resultSet.getString("competition.name"),
                                    resultSet.getDate("competition.date"),
                                    new Organizer(
                                            resultSet.getInt("competition.organizer_id"),
                                            null,null,null,null
                                    ),
                                    new SportBuilding(
                                            resultSet.getInt("competition.sport_building_id"),
                                            null,null,null,null

                                    ),
                                    new KindOfSport(
                                            resultSet.getInt("competition.kind_of_sport_id"),
                                            null
                                    )
                            ),
                            resultSet.getInt("sportsman_competition.prize_place")
                    )

            );
        }
        String sql = "DELETE FROM sportsman_competition WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        else  return null;
    }

    @Override
    public List<SportsmanCompetition> getAll() throws SQLException {
        List<SportsmanCompetition> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM sportsman_competition join sportsman\n" +
                "on sportsman_competition.sportsman_id=sportsman.id\n" +
                "join competition \n" +
                "on sportsman_competition.competition_id=competition.id\n" +
                "order by sportsman_competition.id");
        while (resultSet.next()){
            list.add(new SportsmanCompetition(
                    resultSet.getInt("sportsman_competition.id"),
                    new Sportsman(
                            resultSet.getInt("sportsman.id"),
                            resultSet.getString("sportsman.name"),
                            resultSet.getInt("sportsman.age"),
                            resultSet.getString("sportsman.gender"),
                            new SportClub(
                                    resultSet.getInt("sportsman.sport_club_id"),
                                    null,null,null,null
                            )

                    ),
                    new Competition(
                            resultSet.getInt("competition.id"),
                            resultSet.getString("competition.name"),
                            resultSet.getDate("competition.date"),
                            new Organizer(
                                    resultSet.getInt("competition.organizer_id"),
                                    null,null,null,null
                            ),
                            new SportBuilding(
                                    resultSet.getInt("competition.sport_building_id"),
                                    null,null,null,null

                            ),
                            new KindOfSport(
                                    resultSet.getInt("competition.kind_of_sport_id"),
                                    null
                            )
                    ),
                    resultSet.getInt("sportsman_competition.prize_place")
                    )

            );
        }
        return list;
    }

    /*@Override
    public SportsmanCompetition insertSportsmanCompetition(SportsmanCompetition sportsmanCompetition) {
        dataStorage.getSportsmanCompetitions().add(sportsmanCompetition);
        return sportsmanCompetition;
    }

    @Override
    public SportsmanCompetition getSportsmanCompetition(int id) {
        return dataStorage.getSportsmanCompetitions().get(id);
    }

    @Override
    public SportsmanCompetition updateSportsmanCompetition(SportsmanCompetition sportsmanCompetition) {
        for (SportsmanCompetition sc : dataStorage.getSportsmanCompetitions()) {
            if(sc.getId() == sportsmanCompetition.getId()){
                sc.setSportsman(sportsmanCompetition.getSportsman());
                sc.setCompetition(sportsmanCompetition.getCompetition());
                sc.setPrizePlace(sportsmanCompetition.getPrizePlace());
                break;
            }
        }
        return sportsmanCompetition;
    }

    @Override
    public SportsmanCompetition deleteSportsmanCompetition(int id) {
        SportsmanCompetition sportsmanCompetition = dataStorage.getSportsmanCompetitions()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportsmanCompetitions().indexOf(sportsmanCompetition);
        dataStorage.getSportsmanCompetitions().remove(index);
        return sportsmanCompetition;
    }

    @Override
    public List<SportsmanCompetition> getAll() {
        return dataStorage.getSportsmanCompetitions();
    }*/
}
