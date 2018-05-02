package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Court;
@Repository

public interface CourtRepository extends CrudRepository<Court,Integer> {
}
