package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.KindOfSport;

public interface KindOfSportRepository extends CrudRepository<KindOfSport,Integer> {
}
