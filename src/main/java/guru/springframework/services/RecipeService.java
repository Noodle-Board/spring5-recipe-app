package guru.springframework.services;

import guru.springframework.domain.Recipe;

import java.util.Set;

/**
 * Created by ze on 8/4/23
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
