package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.SportClub;
@Repository
public interface SportClubRepository extends CrudRepository<SportClub,Integer> {
}
