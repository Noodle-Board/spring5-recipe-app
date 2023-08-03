package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ze on 8/3/23
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
