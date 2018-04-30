package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.Organizer;

public interface OrganizerRepository extends CrudRepository<Organizer,Integer> {
}
