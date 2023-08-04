package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ze on 8/4/23
 */
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }



    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if(!pinchUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if(!ounceUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();

        //getCategories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");

        if(!italianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");

        if(!fastFoodCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        //get optionals
        Category americanCategory = americanCategoryOptional.get();
        Category italianCategory = italianCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();
        Category fastFoodCategory = fastFoodCategoryOptional.get();

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setServings(3);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut the avocados: Cut the avocados in half. Remove the pit. " +
                "Score the inside of the avocado with a blunt knife and scoop out the flesh with " +
                "a spoon. Place in a bowl\n" +
                "2 Mash the avocado flesh: Using a fork, roughly mash the avocado. (Don't overdo it! " +
                "The guacamole should be a little chunky.)\n" +
                "3 Add the remaining ingredients to taste: Sprinkle with salt and lime (or lemon) juice." +
                "The acid in the lime juice will provide some balance to the richness of the avocado and " +
                "will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chillis. Chili peppers vary individually " +
                "in their spiciness. So, start wiht a half of one chili pepper and add more to the guacamole " +
                "to your desired degree of heat.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh " +
                "ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Serve immediately: If making a few hours ahead, place plastic wrap on the surface " +
                "of the guacamole and press down to cover it to prevent air reaching it. (The oxygen " +
                "in the air causes oxidation which will turn the guacamole brown.)\n" +
                "Garnish with slices of red radish or jigama strips. Serve with your choice of " +
                "store-bought tortilla chips or make your own.\n" +
                "Refrigerate leftover guacamole up to 3 days.\n" +
                "NOTE: Chilling tomatoes hurts their flavor. aso, if you want to add chopped tomato " +
                "to your guacamole, add it just before serving.\n");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("Once you have basic guacamole down, feel free to experiment with variations by " +
                "adding strawberries, peaches, pineapple, mangoes, or even watermelon. One classic Mexican guacamole " +
                "has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative " +
                "with your homemade guacamole!");
        guacNotes.setRecipe(guacRecipe);

        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("Ripe Avocados", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Kosher Salt", new BigDecimal("0.25"), teaSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Fresh Lime Juice", new BigDecimal(1), tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Minced Red Onion", new BigDecimal(3), tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Serrano Chili", new BigDecimal(1), eachUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Cilantro, Finely Chopped", new BigDecimal(2), tableSpoonUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Freshly Ground Black Pepper", new BigDecimal(1), pinchUom, guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Ripe Tomato Chopped", new BigDecimal(".5"), eachUom, guacRecipe));

        guacRecipe.getCategories().add(mexicanCategory);
        guacRecipe.getCategories().add(americanCategory);

        guacRecipe.setSource("SimplyRecipes.com");
        guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        //add to return list
        recipes.add(guacRecipe);

        Recipe spicyGrilledChickenTacosRecipe = new Recipe();
        spicyGrilledChickenTacosRecipe.setDescription("Spicy Grilled Chicken Tacos");
        spicyGrilledChickenTacosRecipe.setPrepTime(20);
        spicyGrilledChickenTacosRecipe.setCookTime(15);
        spicyGrilledChickenTacosRecipe.setServings(5);
        spicyGrilledChickenTacosRecipe.setDifficulty(Difficulty.MODERATE);
        spicyGrilledChickenTacosRecipe.setDirections("1 Prepare the grill: Prepare either a gas or charcoal grill for " +
                "medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, " +
                "cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose " +
                "paste. Add the chicken to the bowl and toss to coat all over.\n Set aside to marinate while the grill " +
                "heats and you prepare the rest of the toppings.\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted " +
                "into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Thin the sour cream with milk: Stir together the sour cream and milk to thin out the sour cream to " +
                "make it easy to drizzle.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of " +
                "arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with " +
                "the thinned sour cream. Serve with lime wedges.\n" +
                "6 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. " +
                "As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat " +
                "for a few seconds on the other side.\nWrap warmed tortillas in a tea towel to keep them warm until " +
                "serving.");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes(" We have a family motto and it is this: Everything goes better in a tortilla.\n\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled " +
                "jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot " +
                "pan on the stove comes wafting through the house.\n\n" +
                "Today's tacos are more purposeful a deliberate meal instead of a secretive midnight snack!\n\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and " +
                "sweet orange juice while the grill is heating. You can also use this time to prepare the taco " +
                "toppings.\n\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the " +
                "tacos and dig in. The whole meal comes together in about 30 minutes! ");
        tacoNotes.setRecipe(spicyGrilledChickenTacosRecipe);

        spicyGrilledChickenTacosRecipe.setNotes(tacoNotes);

        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tableSpoonUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoonUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoonUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Sugar", new BigDecimal(1), teaSpoonUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Kosher Salt", new BigDecimal(".5"), teaSpoonUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Garlic Clove Finely Chopped", new BigDecimal(1), eachUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Orange Zest, Finely Grated", new BigDecimal(1), tableSpoonUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Orange Juice, Fresh-Squeezed", new BigDecimal(3), tableSpoonUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Olive Oil", new BigDecimal(2), tableSpoonUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Boneless Skinless Chicken Breast", new BigDecimal(5), eachUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Corn Tortillas", new BigDecimal(8), eachUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Baby Arugula", new BigDecimal(3), ounceUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Ripe Avocados, Sliced", new BigDecimal(2), eachUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Radishes, Thinly Sliced", new BigDecimal(4), eachUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Cherry Tomatoes, Halves", new BigDecimal(".5"), pintUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Red Onion, Thinly Sliced", new BigDecimal(".25"), eachUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Cilantro Roughly Chopped", new BigDecimal(1), ounceUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Sour Cream", new BigDecimal(".5"), cupUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Milk", new BigDecimal(".25"), cupUom, spicyGrilledChickenTacosRecipe));
        spicyGrilledChickenTacosRecipe.getIngredients().add(new Ingredient("Lime, cut into wedges", new BigDecimal(1), eachUom, spicyGrilledChickenTacosRecipe));

        spicyGrilledChickenTacosRecipe.getCategories().add(mexicanCategory);
        spicyGrilledChickenTacosRecipe.getCategories().add(americanCategory);

        spicyGrilledChickenTacosRecipe.setSource("SimplyRecipes.com");
        spicyGrilledChickenTacosRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos");

        //add to return list
        recipes.add(spicyGrilledChickenTacosRecipe);

        return recipes;

    }

}
