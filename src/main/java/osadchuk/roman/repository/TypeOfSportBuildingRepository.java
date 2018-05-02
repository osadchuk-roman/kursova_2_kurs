package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.TypeOfSportBuilding;
@Repository
public interface TypeOfSportBuildingRepository extends CrudRepository<TypeOfSportBuilding,Integer> {
}
