package osadchuk.roman.DAO.pool.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osadchuk.roman.DAO.pool.interfaces.IPoolDAO;
import osadchuk.roman.datastorage.DataStorageFake;
import osadchuk.roman.model.Pool;

import java.util.List;

@Component
public class PoolDAOFakeImpl implements IPoolDAO {
    @Autowired
    DataStorageFake dataStorage;

    @Override
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
    }
}
