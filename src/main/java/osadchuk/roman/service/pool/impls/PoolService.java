package osadchuk.roman.service.pool.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.pool.impls.PoolDAOFakeImpl;
import osadchuk.roman.model.Pool;
import osadchuk.roman.service.pool.interfaces.IPoolService;

import java.util.List;

@Service
public class PoolService implements IPoolService {
    @Autowired
    PoolDAOFakeImpl poolDAO;

    @Override
    public Pool insertPool(Pool pool) {
        return poolDAO.insertPool(pool);
    }

    @Override
    public Pool getPool(int id) {
        return poolDAO.getPool(id);
    }

    @Override
    public Pool updatePool(Pool pool) {
        return poolDAO.updatePool(pool);
    }

    @Override
    public Pool deletePool(int id) {
        return poolDAO.deletePool(id);
    }

    @Override
    public List<Pool> getAll() {
        return poolDAO.getAll();
    }
}
