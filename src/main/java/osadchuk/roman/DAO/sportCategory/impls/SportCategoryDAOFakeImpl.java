package osadchuk.roman.DAO.sportCategory.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.sportCategory.interfaces.ISportCategoryDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.SportCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SportCategoryDAOFakeImpl implements ISportCategoryDAO {
    @Autowired
    DataStorageJDBC dataStorage;
    //DataStorageFake dataStorage;

    @Override
    public SportCategory insertSportCategory(SportCategory sportCategory) {
        return null;
    }

    @Override
    public SportCategory getSportCategory(int id) {
        return null;
    }

    @Override
    public SportCategory updateSportCategory(SportCategory sportCategory) {
        return null;
    }

    @Override
    public SportCategory deleteSportCategory(int id) throws SQLException {
        List<SportCategory> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM `information system of sports organizations`.sport_category where id="+id);
        while (resultSet.next()){
            list.add(new SportCategory(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));


        }
        String sql = "DELETE FROM sport_category WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        /*if (rowsDeleted > 0) {
            return kindOfSport;
        }*/
        return list.get(0);
    }

    @Override
    public List<SportCategory> getAll() throws SQLException {
        List<SportCategory> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM `information system of sports organizations`.sport_category");
        while (resultSet.next()){
            list.add(new SportCategory(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
            ));


        }
        return list;
    }

    /*@Override
    public SportCategory insertSportCategory(SportCategory sportCategory) {
         dataStorage.getSportCategories().add(sportCategory);
         return sportCategory;
    }

    @Override
    public SportCategory getSportCategory(int id) {
        return dataStorage.getSportCategories().get(id);
    }

    @Override
    public SportCategory updateSportCategory(SportCategory sportCategory) {
        for (SportCategory s : dataStorage.getSportCategories()) {
            if(s.getId() == sportCategory.getId()){
                s.setName(sportCategory.getName());
                break;
            }
        }
        return sportCategory;
    }

    @Override
    public SportCategory deleteSportCategory(int id) {
        SportCategory sportCategory = dataStorage.getSportCategories()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getSportCategories().indexOf(sportCategory);
        dataStorage.getSportCategories().remove(index);
        return sportCategory;
    }

    @Override
    public List<SportCategory> getAll() {
        return dataStorage.getSportCategories();
    }*/
}
