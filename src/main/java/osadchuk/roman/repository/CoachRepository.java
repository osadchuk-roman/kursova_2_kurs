package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Coach;
@Repository
public interface CoachRepository extends CrudRepository<Coach,Integer> {
}
