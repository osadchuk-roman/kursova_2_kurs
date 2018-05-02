package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.KindOfSport;
@Repository
public interface KindOfSportRepository extends CrudRepository<KindOfSport,Integer> {
}
