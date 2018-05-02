package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.SportsmanSportCoach;
@Repository
public interface SportsmanSportCoachRepository extends CrudRepository<SportsmanSportCoach,Integer> {
}
