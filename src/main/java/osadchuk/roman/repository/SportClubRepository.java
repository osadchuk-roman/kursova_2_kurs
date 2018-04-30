package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.SportClub;

public interface SportClubRepository extends CrudRepository<SportClub,Integer> {
}
