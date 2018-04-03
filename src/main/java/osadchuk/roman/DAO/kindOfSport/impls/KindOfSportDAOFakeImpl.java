package osadchuk.roman.DAO.kindOfSport.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.kindOfSport.interfaces.IKindOfSportDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.KindOfSport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class KindOfSportDAOFakeImpl implements IKindOfSportDAO {
    @Autowired
    DataStorageJDBC dataStorage;
    //DataStorageFake dataStorage;

    @Override
    public KindOfSport insertKindOfSport(KindOfSport kindOfSport) {
       return null;
    }

    @Override
    public KindOfSport getKindOfSport(int id) {
        return null;
    }

    @Override
    public KindOfSport updateKindOfSport(KindOfSport kindOfSport) {
        return null;
    }

    @Override
    public KindOfSport deleteKindOfSport(int id) {System.err.println("id = " + id);
        return null;
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
}
