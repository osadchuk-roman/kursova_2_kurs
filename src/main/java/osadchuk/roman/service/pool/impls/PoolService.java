package osadchuk.roman.service.pool.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osadchuk.roman.DAO.pool.impls.PoolDAOFakeImpl;
import osadchuk.roman.model.Pool;
import osadchuk.roman.service.pool.interfaces.IPoolService;

import java.sql.SQLException;
import java.util.List;

@Service
public class PoolService implements IPoolService {
    @Autowired
    PoolDAOFakeImpl poolDAO;

    @Override
    public Pool insertPool(Pool pool) throws SQLException {
        return poolDAO.insertPool(pool);
    }

    @Override
    public Pool getPool(int id) throws SQLException {
        return poolDAO.getPool(id);
    }

    @Override
    public Pool updatePool(Pool pool) throws SQLException {
        return poolDAO.updatePool(pool);
    }

    @Override
    public Pool deletePool(int id) throws SQLException {
        return poolDAO.deletePool(id);
    }

    @Override
    public List<Pool> getAll() throws SQLException {
        return poolDAO.getAll();
    }
}
