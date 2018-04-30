package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.Gym;

public interface GymRepository extends CrudRepository<Gym,Integer> {
}
