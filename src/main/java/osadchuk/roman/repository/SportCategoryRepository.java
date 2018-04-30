package osadchuk.roman.repository;

import org.springframework.data.repository.CrudRepository;
import osadchuk.roman.model.SportCategory;

public interface SportCategoryRepository extends CrudRepository<SportCategory,Integer> {
}
