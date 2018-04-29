package osadchuk.roman.DAO.pool.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.pool.interfaces.IPoolDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.datastorage.DataStorageJDBC;
import osadchuk.roman.model.Pool;
import osadchuk.roman.model.SportBuilding;
import osadchuk.roman.model.TypeOfSportBuilding;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PoolDAOFakeImpl implements IPoolDAO {
    @Autowired
    DataStorageJDBC dataStorage;

    @Override
    public Pool insertPool(Pool pool) throws SQLException {
        String sql = "INSERT INTO `information system of sports organizations`.pool " +
                "(sport_building_id, depth, width, length, max_height) VALUES (?,?,?,?,?)";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        //statement.setLong(1, kindOfSport.getId());
        statement.setInt(1,pool.getSportBuilding().getId());
        statement.setInt(2,pool.getDepth());
        statement.setInt(3,pool.getWidth());
        statement.setInt(4,pool.getLength());
        statement.setInt(5,pool.getMaxHeight());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        if (rowsInserted>0)
            return pool;
        else
            return null;
    }

    @Override
    public Pool getPool(int id) throws SQLException {
        List<Pool> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM pool join sport_building\n" +
                        "on pool.sport_building_id=sport_building.id join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id=type_of_sport_building.id\n" +
                        "where pool.id="+id+" order by pool.id"
        );
        while (resultSet.next()){
            list.add(new Pool(
                    resultSet.getInt("pool.id"),
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
                    resultSet.getInt("pool.depth"),
                    resultSet.getInt("pool.width"),
                    resultSet.getInt("pool.length"),
                    resultSet.getInt("pool.max_height")
            ));

        }
        return list.get(0);
    }

    @Override
    public Pool updatePool(Pool pool) throws SQLException {
        String sql  ="UPDATE pool SET pool.sport_building_id =?, pool.depth=?, " +
                "pool.width=?,pool.length=?, pool.max_height=? WHERE pool.id=?";
        PreparedStatement statement  =dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1,pool.getSportBuilding().getId());
        statement.setInt(2,pool.getDepth());
        statement.setInt(3,pool.getWidth());
        statement.setInt(4,pool.getLength());
        statement.setInt(5,pool.getMaxHeight());
        statement.setInt(6,pool.getId());
        int rowsUpdated  = statement.executeUpdate();
        statement.close();
        if (rowsUpdated >0)
            return pool;
        else
            return null;
    }

    @Override
    public Pool deletePool(int id) throws SQLException {
        List<Pool> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM pool join sport_building\n" +
                        "on pool.sport_building_id=sport_building.id join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id=type_of_sport_building.id\n" +
                        "where pool.id="+id+" order by pool.id"
        );
        while (resultSet.next()){
            list.add(new Pool(
                    resultSet.getInt("pool.id"),
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
                    resultSet.getInt("pool.depth"),
                    resultSet.getInt("pool.width"),
                    resultSet.getInt("pool.length"),
                    resultSet.getInt("pool.max_height")
            ));

        }
        String sql = "DELETE FROM pool WHERE id=?";
        PreparedStatement statement = dataStorage.getCon().prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();


        if (rowsDeleted > 0) {
            return list.get(0);
        }
        else  return null;

    }

    @Override
    public List<Pool> getAll() throws SQLException {
        List<Pool> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery(
                "SELECT * FROM pool join sport_building\n" +
                        "on pool.sport_building_id=sport_building.id join type_of_sport_building\n" +
                        "on sport_building.type_of_sport_building_id=type_of_sport_building.id\n" +
                        "order by pool.id"
        );
        while (resultSet.next()){
            list.add(new Pool(
                    resultSet.getInt("pool.id"),
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
                    resultSet.getInt("pool.depth"),
                    resultSet.getInt("pool.width"),
                    resultSet.getInt("pool.length"),
                    resultSet.getInt("pool.max_height")
            ));

        }
        return list;
    }

    /*@Override
    public Pool insertPool(Pool pool) {
        dataStorage.getPools().add(pool);
        return pool;
    }

    @Override
    public Pool getPool(int id) {
        return dataStorage.getPools().get(id);
    }

    @Override
    public Pool updatePool(Pool pool) {
        for (Pool p : dataStorage.getPools()) {
            if(p.getId() == pool.getId()){
                p.setSportBuilding(pool.getSportBuilding());
                p.setDepth(pool.getDepth());
                p.setLength(pool.getLength());
                p.setWidth(pool.getWidth());
                p.setMaxHeight(pool.getMaxHeight());
                break;
            }
        }
        return pool;
    }

    @Override
    public Pool deletePool(int id) {
        Pool pool = dataStorage.getPools()
                .stream()
                .filter(el -> el.getId() == id)
                .findFirst()
                .get();
        int index = dataStorage.getPools().indexOf(pool);
        dataStorage.getPools().remove(index);
        return pool;
    }

    @Override
    public List<Pool> getAll() {
        return dataStorage.getPools();
    }*/
}
