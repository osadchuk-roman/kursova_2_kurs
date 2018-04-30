package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.Competition;

public interface CompetitionRepository extends CrudRepository<Competition,Integer> {
}
