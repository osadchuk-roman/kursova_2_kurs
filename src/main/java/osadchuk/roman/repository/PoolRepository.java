package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Pool;
@Repository

public interface PoolRepository extends CrudRepository<Pool,Integer> {
}
