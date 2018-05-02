package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import osadchuk.roman.model.Organizer;
@Repository

public interface OrganizerRepository extends CrudRepository<Organizer,Integer> {
}
