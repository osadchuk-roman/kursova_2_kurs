package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Stadium;
@Repository
public interface StadiumRepository extends CrudRepository<Stadium,Integer> {
}
