package osadchuk.roman.DAO.pool.interfaces;

import osadchuk.roman.model.Pool;

import java.util.List;

public interface IPoolDAO {
    public Pool insertPool(Pool pool);
    public Pool getPool(int id);
    public Pool updatePool(Pool pool);
    public Pool deletePool(int id);
    public List<Pool> getAll();
}