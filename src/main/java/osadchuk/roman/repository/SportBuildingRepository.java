package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.SportBuilding;
@Repository

public interface SportBuildingRepository extends CrudRepository<SportBuilding,Integer> {
}
