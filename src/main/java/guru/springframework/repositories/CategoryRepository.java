package guru.springframework.repositories;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ze on 8/3/23
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
