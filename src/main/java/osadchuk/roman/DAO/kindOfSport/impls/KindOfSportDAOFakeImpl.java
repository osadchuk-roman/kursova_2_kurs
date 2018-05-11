package osadchuk.roman.DAO.kindOfSport.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.kindOfSport.interfaces.IKindOfSportDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.KindOfSport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class KindOfSportDAOFakeImpl implements IKindOfSportDAO {
    @Autowired
    //DataStorageFake dataStorage;
    DataStorageJDBC dataStorage;


    @Override
    public KindOfSport insertKindOfSport(KindOfSport kindOfSport) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.kind_of_sport (name) VALUES (?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        //statement.setLong(1, kindOfSport.getId());
        statement.setString(1, kindOfSport.getName());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return kindOfSport;
        else
            return null;
    }

    @Override
    public KindOfSport getKindOfSport(int id) throws SQLException {
        List<KindOfSport> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage
                .executeQuery("SELECT * FROM `information system of sports organizations`.kind_of_sport where id="+id);
        while (resultSet.next()){
            list.add(new KindOfSport(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));
        }
        return list.get(0);
    }

    @Override
    public KindOfSport updateKindOfSport(KindOfSport kindOfSport) throws SQLException {
        String sql  ="UPDATE kind_of_sport SET kind_of_sport.name =?  WHERE kind_of_sport.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,kindOfSport.getName());
        statement.setInt(2,(int)kindOfSport.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return kindOfSport;
        else
            return null;
    }

    @Override
    public KindOfSport deleteKindOfSport(int id) throws SQLException {
        List<KindOfSport> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM `information system of sports organizations`.kind_of_sport where id="+id);
        while (resultSet.next()){
            list.add(new KindOfSport(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));


        }
        String sql = "DELETE FROM kind_of_sport WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        /*if (rowsDeleted > 0) {
            return kindOfSport;
        }*/
        return list.get(0);
    }

    @Override
    public List<KindOfSport> getAll() throws SQLException {
        List<KindOfSport> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM `information system of sports organizations`.kind_of_sport");
        while (resultSet.next()){
            list.add(new KindOfSport(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));


        }
        return list;
    }

    /*@Override
    public KindOfSport insertKindOfSport(KindOfSport kindOfSport) {
        dataStorage.getKindsOfSports().add(kindOfSport);
        return kindOfSport;
    }

    @Override
    public KindOfSport getKindOfSport(int id) {
        return dataStorage.getKindsOfSports().get(id);
    }

    @Override
    public KindOfSport updateKindOfSport(KindOfSport kindOfSport) {
        for (KindOfSport k : dataStorage.getKindsOfSports()) {
            if(k.getId() == kindOfSport.getId()){
                k.setName(kindOfSport.getName());
                break;
            }
        }
        return kindOfSport;
    }

    @Override
    public KindOfSport deleteKindOfSport(int id) {
        KindOfSport kindOfSport = dataStorage.getKindsOfSports()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getKindsOfSports().indexOf(kindOfSport);
        dataStorage.getKindsOfSports().remove(index);
        return kindOfSport;
    }

    @Override
    public List<KindOfSport> getAll() throws SQLException {
        return dataStorage.getKindsOfSports();
    }
*/
}
