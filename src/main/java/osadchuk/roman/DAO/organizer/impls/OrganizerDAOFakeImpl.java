package osadchuk.roman.DAO.organizer.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.organizer.interfaces.IOrganizerDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.Organizer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizerDAOFakeImpl implements IOrganizerDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public Organizer insertOrganizer(Organizer organizer) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.organizer" +
                " (name,admin_name,phone,address) VALUES (?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        //statement.setLong(1, kindOfSport.getId());
        statement.setString(1,organizer.getName());
        statement.setString(2,organizer.getAdminName());
        statement.setString(3,organizer.getPhone());
        statement.setString(4,organizer.getAddress());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return organizer;
        else
            return null;
    }

    @Override
    public Organizer getOrganizer(int id) throws SQLException {
        List<Organizer> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage
                .executeQuery("SELECT * FROM `information system of sports organizations`.organizer where id="+id);
        while (resultSet.next()){
            list.add(new Organizer(
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
    public Organizer updateOrganizer(Organizer organizer) throws SQLException {
        String sql  ="UPDATE organizer SET organizer.name =?, organizer.admin_name =?, " +
                "organizer.phone =?, organizer.address =?,  WHERE organizer.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setString(1,organizer.getName());
        statement.setString(2,organizer.getAdminName());
        statement.setString(3,organizer.getPhone());
        statement.setString(4,organizer.getAddress());
        statement.setInt(5,(int)organizer.getId());

        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return organizer;
        else
            return null;
    }

    @Override
    public Organizer deleteOrganizer(int id) throws SQLException {
        List<Organizer> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM `information system of sports organizations`.organizer where id="+id);
        while (resultSet.next()){
            list.add(new Organizer(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("admin_name"),
                    resultSet.getString("phone"),
                    resultSet.getString("address")
            ));


        }
        String sql = "DELETE FROM organizer WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        /*if (rowsDeleted > 0) {
            return kindOfSport;
        }*/
        return list.get(0);
    }

    @Override
    public List<Organizer> getAll() throws SQLException {
        List<Organizer> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM `information system of sports organizations`.organizer");
        while (resultSet.next()){
            list.add(new Organizer(
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
    public Organizer insertOrganizer(Organizer organizer) {
        dataStorage.getOrganizes().add(organizer);
        return organizer;
    }

    @Override
    public Organizer getOrganizer(int id) {
        return dataStorage.getOrganizes().get(id);
    }

    @Override
    public Organizer updateOrganizer(Organizer organizer) {
        for (Organizer o : dataStorage.getOrganizes()) {
            if(o.getId() == organizer.getId()){
                o.setName(organizer.getName());
                o.setAdminName(organizer.getAdminName());
                o.setPhone(organizer.getPhone());
                o.setAddress(organizer.getAddress());
                break;
            }
        }
        return organizer;
    }

    @Override
    public Organizer deleteOrganizer(int id) {
        Organizer organizer = dataStorage.getOrganizes()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getOrganizes().indexOf(organizer);
        dataStorage.getOrganizes().remove(index);
        return organizer;
    }

    @Override
    public List<Organizer> getAll() {
        return dataStorage.getOrganizes();
    }*/
}
