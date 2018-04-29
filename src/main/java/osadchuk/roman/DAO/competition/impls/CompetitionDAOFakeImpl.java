package osadchuk.roman.DAO.competition.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.competition.interfaces.ICompetitionDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CompetitionDAOFakeImpl implements ICompetitionDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public Competition insertCompetition(Competition competition) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.competition" +
                " (name, date, organizer_id, sport_building_id, kind_of_sport_id) VALUES (?,?,?,?,?)";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,competition.getName());
        statement.setDate(2,competition.getDate());
        statement.setInt(3,competition.getOrganizer().getId());
        statement.setInt(4,competition.getSportBuilding().getId());
        statement.setInt(5,competition.getKindOfSport().getId());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return competition;
        else
            return null;
    }

    @Override
    public Competition getCompetition(int id) throws SQLException {
        List<Competition> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM competition join organizer\n" +
                "on competition.organizer_id=organizer.id\n" +
                "join sport_building \n" +
                "on competition.sport_building_id=sport_building.id\n" +
                "join kind_of_sport\n" +
                "on competition.kind_of_sport_id=kind_of_sport.id\n" +
                "where competition.id="+id+" order by competition.id");
        while (resultSet.next()){
            list.add(new Competition(
                    resultSet.getInt("competition.id"),
                    resultSet.getString("competition.name"),
                    resultSet.getDate("competition.date"),
                    new Organizer(
                            resultSet.getInt("organizer.id"),
                            resultSet.getString("organizer.name"),
                            resultSet.getString("organizer.admin_name"),
                            resultSet.getString("organizer.phone"),
                            resultSet.getString("organizer.address")
                    ),
                    new SportBuilding(
                            resultSet.getInt("sport_building.id"),
                            resultSet.getString("sport_building.name"),
                            new TypeOfSportBuilding(
                                    resultSet.getInt("sport_building.type_of_sport_building_id"),
                                    null
                            ),
                            resultSet.getString("sport_building.phone"),
                            resultSet.getString("sport_building.address")

                    ),
                    new KindOfSport(
                            resultSet.getInt("kind_of_sport.id"),
                            resultSet.getString("kind_of_sport.name")
                    )
            ));
        }
        return list.get(0);
    }

    @Override
    public Competition updateCompetition(Competition competition) throws SQLException {
        String sql  ="UPDATE competition SET competition.name =?, competition.date =?, " +
                "competition.organizer_id =?,competition.sport_building_id =?, " +
                "competition.kind_of_sport_id =?  WHERE competition.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,competition.getName());
        statement.setDate(2,competition.getDate());
        statement.setInt(3,competition.getOrganizer().getId());
        statement.setInt(4,competition.getSportBuilding().getId());
        statement.setInt(5,competition.getKindOfSport().getId());
        statement.setInt(6,competition.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return competition;
        else
            return null;
    }

    @Override
    public Competition deleteCompetition(int id) throws SQLException {
        List<Competition> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM competition join organizer\n" +
                "on competition.organizer_id=organizer.id\n" +
                "join sport_building \n" +
                "on competition.sport_building_id=sport_building.id\n" +
                "join kind_of_sport\n" +
                "on competition.kind_of_sport_id=kind_of_sport.id\n" +
                "where competition.id="+id+" order by competition.id");
        while (resultSet.next()){
            list.add(new Competition(
                    resultSet.getInt("competition.id"),
                    resultSet.getString("competition.name"),
                    resultSet.getDate("competition.date"),
                    new Organizer(
                            resultSet.getInt("organizer.id"),
                            resultSet.getString("organizer.name"),
                            resultSet.getString("organizer.admin_name"),
                            resultSet.getString("organizer.phone"),
                            resultSet.getString("organizer.address")
                    ),
                    new SportBuilding(
                            resultSet.getInt("sport_building.id"),
                            resultSet.getString("sport_building.name"),
                            new TypeOfSportBuilding(
                                    resultSet.getInt("sport_building.type_of_sport_building_id"),
                                    null
                            ),
                            resultSet.getString("sport_building.phone"),
                            resultSet.getString("sport_building.address")

                    ),
                    new KindOfSport(
                            resultSet.getInt("kind_of_sport.id"),
                            resultSet.getString("kind_of_sport.name")
                    )
            ));
        }
        String sql = "DELETE FROM competition WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Competition> getAll() throws SQLException {
        List<Competition> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM competition join organizer\n" +
                "on competition.organizer_id=organizer.id\n" +
                "join sport_building \n" +
                "on competition.sport_building_id=sport_building.id\n" +
                "join kind_of_sport\n" +
                "on competition.kind_of_sport_id=kind_of_sport.id\n" +
                "order by competition.id");
        while (resultSet.next()){
            list.add(new Competition(
                    resultSet.getInt("competition.id"),
                    resultSet.getString("competition.name"),
                    resultSet.getDate("competition.date"),
                    new Organizer(
                            resultSet.getInt("organizer.id"),
                            resultSet.getString("organizer.name"),
                            resultSet.getString("organizer.admin_name"),
                            resultSet.getString("organizer.phone"),
                            resultSet.getString("organizer.address")
                    ),
                    new SportBuilding(
                            resultSet.getInt("sport_building.id"),
                            resultSet.getString("sport_building.name"),
                            new TypeOfSportBuilding(
                                    resultSet.getInt("sport_building.type_of_sport_building_id"),
                                    null
                            ),
                            resultSet.getString("sport_building.phone"),
                            resultSet.getString("sport_building.address")

                    ),
                    new KindOfSport(
                            resultSet.getInt("kind_of_sport.id"),
                            resultSet.getString("kind_of_sport.name")
                    )
            ));
        }
        return list;
    }
    //DataStorageFake dataStorage;

    /*@Override
    public Competition insertCompetition(Competition competition) {
        dataStorage.getCompetitions().add(competition);
        return competition;
    }

    @Override
    public Competition getCompetition(int id) {
        return dataStorage.getCompetitions().get(id);
    }

    @Override
    public Competition updateCompetition(Competition competition) {
        for (Competition c : dataStorage.getCompetitions()) {
            if(c.getId() == competition.getId()){
                c.setName(competition.getName());
                c.setDate(competition.getDate());
                c.setOrganizer(competition.getOrganizer());
                c.setSportBuilding(competition.getSportBuilding());
                c.setKindOfSport(competition.getKindOfSport());
                break;
            }
        }
        return competition;
    }

    @Override
    public Competition deleteCompetition(int id) {
        Competition competition = dataStorage.getCompetitions()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getCompetitions().indexOf(competition);
        dataStorage.getCompetitions().remove(index);
        return competition;
    }

    @Override
    public List<Competition> getAll() {
        return dataStorage.getCompetitions();
    }*/
}
