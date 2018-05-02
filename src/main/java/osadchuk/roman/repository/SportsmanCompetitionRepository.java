package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.SportsmanCompetition;
@Repository
public interface SportsmanCompetitionRepository extends CrudRepository<SportsmanCompetition,Integer> {
}
