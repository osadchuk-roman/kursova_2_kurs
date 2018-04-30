package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.SportsmanCompetition;

public interface SportsmanCompetitionRepository extends CrudRepository<SportsmanCompetition,Integer> {
}
