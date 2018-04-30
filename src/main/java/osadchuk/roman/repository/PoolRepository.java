package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.Pool;

public interface PoolRepository extends CrudRepository<Pool,Integer> {
}
