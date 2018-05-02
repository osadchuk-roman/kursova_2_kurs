package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Gym;
@Repository

public interface GymRepository extends CrudRepository<Gym,Integer> {
}
