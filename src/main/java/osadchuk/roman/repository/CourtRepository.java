package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.Court;

public interface CourtRepository extends CrudRepository<Court,Integer> {
}
