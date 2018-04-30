package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.Coach;

public interface SportsmanRepository extends CrudRepository<Coach,Integer> {
}
