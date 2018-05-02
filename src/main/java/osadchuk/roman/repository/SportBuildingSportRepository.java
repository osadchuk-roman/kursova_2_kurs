package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.SportBuildingSport;
@Repository
public interface SportBuildingSportRepository extends CrudRepository<SportBuildingSport,Integer> {
}
