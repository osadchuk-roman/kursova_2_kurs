package osadchuk.roman.DAO.sportBuildingSport.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportBuildingSport.interfaces.ISportBuildingSportDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.KindOfSport;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.SportBuildingSport;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SportBuildingSportDAOFakeImpl implements ISportBuildingSportDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public SportBuildingSport insertSportBuildingSport(SportBuildingSport sportBuildingSport) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.sport_building_sport " +
                "(sport_building_id, kind_of_sport_id) VALUES (?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        //statement.setLong(1, kindOfSport.getId());
        statement.setInt(1,sportBuildingSport.getSportBuilding().getId());
        statement.setInt(2,(int)sportBuildingSport.getKindOfSport().getId());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return sportBuildingSport;
        else
            return null;
    }

    @Override
    public SportBuildingSport getSportBuildingSport(int id) throws SQLException {
        List<SportBuildingSport> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("select * from sport_building_sport join kind_of_sport\n" +
                "on sport_building_sport.kind_of_sport_id = kind_of_sport.id\n" +
                "join sport_building on sport_building_sport.sport_building_id=sport_building.id\n" +
                "join type_of_sport_building on \n" +
                "sport_building.type_of_sport_building_id = type_of_sport_building.id\n" +
                "where sport_building_sport.id="+id+" order by sport_building_sport.id");
        while (resultSet.next()){
            list.add(new SportBuildingSport(
                    resultSet.getInt("sport_building_sport.id"),
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
                    new KindOfSport(
                            resultSet.getInt("kind_of_sport.id"),
                            resultSet.getString("kind_of_sport.name")
                    )

            ));

        }
        return list.get(0);
    }

    @Override
    public SportBuildingSport updateSportBuildingSport(SportBuildingSport sportBuildingSport) throws SQLException {
        String sql  ="UPDATE sport_building_sport SET " +
                "sport_building_sport.sport_building_id=?,sport_building_sport.kind_of_sport_id=?" +
                " WHERE sport_building_sport.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,sportBuildingSport.getSportBuilding().getId());
        statement.setInt(2,(int)sportBuildingSport.getKindOfSport().getId());
        statement.setInt(3,sportBuildingSport.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return sportBuildingSport;
        else
            return null;
    }

    @Override
    public SportBuildingSport deleteSportBuildingSport(int id) throws SQLException {
        List<SportBuildingSport> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("select * from sport_building_sport join kind_of_sport\n" +
                "on sport_building_sport.kind_of_sport_id = kind_of_sport.id\n" +
                "join sport_building on sport_building_sport.sport_building_id=sport_building.id\n" +
                "join type_of_sport_building on \n" +
                "sport_building.type_of_sport_building_id = type_of_sport_building.id\n" +
                "where sport_building_sport.id="+id+" order by sport_building_sport.id");
        while (resultSet.next()){
            list.add(new SportBuildingSport(
                    resultSet.getInt("sport_building_sport.id"),
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
                    new KindOfSport(
                            resultSet.getInt("kind_of_sport.id"),
                            resultSet.getString("kind_of_sport.name")
                    )

            ));

        }
        String sql = "DELETE FROM sport_building_sport WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        else  return null;
    }

    @Override
    public List<SportBuildingSport> getAll() throws SQLException {
        List<SportBuildingSport> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("select * from sport_building_sport join kind_of_sport\n" +
                "on sport_building_sport.kind_of_sport_id = kind_of_sport.id\n" +
                "join sport_building on sport_building_sport.sport_building_id=sport_building.id\n" +
                "join type_of_sport_building on \n" +
                "sport_building.type_of_sport_building_id = type_of_sport_building.id\n" +
                "order by sport_building_sport.id");
        while (resultSet.next()){
            list.add(new SportBuildingSport(
                    resultSet.getInt("sport_building_sport.id"),
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
    public SportBuildingSport insertSportBuildingSport(SportBuildingSport sportBuildingSport) {
        dataStorage.getSportBuildingSports().add(sportBuildingSport);
        return sportBuildingSport;
    }

    @Override
    public SportBuildingSport getSportBuildingSport(int id) {
        return dataStorage.getSportBuildingSports().get(id);
    }

    @Override
    public SportBuildingSport updateSportBuildingSport(SportBuildingSport sportBuildingSport) {
        for (SportBuildingSport sbs : dataStorage.getSportBuildingSports()) {
            if(sbs.getId() == sportBuildingSport.getId()){
                sbs.setKindOfSport(sportBuildingSport.getKindOfSport());
                sbs.setSportBuilding(sportBuildingSport.getSportBuilding());
                break;
            }
        }
        return sportBuildingSport;
    }

    @Override
    public SportBuildingSport deleteSportBuildingSport(int id) {
        SportBuildingSport sportBuildingSport = dataStorage.getSportBuildingSports()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportBuildingSports().indexOf(sportBuildingSport);
        dataStorage.getSportBuildingSports().remove(index);
        return sportBuildingSport;
    }

    @Override
    public List<SportBuildingSport> getAll() {
        return dataStorage.getSportBuildingSports();
    }*/
}
