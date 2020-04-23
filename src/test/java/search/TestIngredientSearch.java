package search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import containers.Data;
import containers.Recipe;
import index.IndexIngredents;
import index.IndexRecipes;

class TestIngredientSearch {

	@Test
	void test() {
		Data data = new Data();
		data.recipeById = makeRecipes();
		
		IndexIngredents index = new IndexIngredents(data.recipeById);
		data.recipeByIngredent = index.index();
		
		IngredientSearch search = new IngredientSearch(data);
		System.out.println(search.search("chicken,onion"));
		
	
		
	}
	
	HashMap<Integer, Recipe>  makeRecipes() {
		Recipe r1 = new Recipe(Arrays.asList("chicken", "onion", "pepper"));
		Recipe r2 = new Recipe(Arrays.asList("chicken", "bacon", "lamb"));
		Recipe r3 = new Recipe(Arrays.asList("chicken", "duck", "cow"));
		Recipe r4 = new Recipe(Arrays.asList("chicken", "lemon", "lime"));
		Recipe r5 = new Recipe(Arrays.asList("chicken", "smoke", "pepper"));

		Recipe r6 = new Recipe(Arrays.asList("bird", "skin", "pepper"));
		Recipe r7 = new Recipe(Arrays.asList("bird", "rosemarry", "thyme"));
		Recipe r8 = new Recipe(Arrays.asList("bird", "lettuce", "noddle"));
		Recipe r9 = new Recipe(Arrays.asList("bird", "sauce", "salt"));
		Recipe r10 = new Recipe(Arrays.asList("bird", "chili power", "pepper"));
		
		Recipe r11 = new Recipe(Arrays.asList("beef", "salt", "pepper"));
		Recipe r12 = new Recipe(Arrays.asList("beef", "butt rub", "seasoned salt"));
		Recipe r13 = new Recipe(Arrays.asList("beef", "smoke", "pepper"));
		Recipe r14 = new Recipe(Arrays.asList("beef", "pineapple", "lime"));
		Recipe r15 = new Recipe(Arrays.asList("beef", "wine", "heavy whipping cream"));
		List<Recipe> recipes = Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
		
		HashMap<Integer, Recipe> recipeById = new HashMap<Integer, Recipe>();
		
		for(int i = 0; i < 15; ++i) {
			recipeById.put(i, recipes.get(i));
		}

		return recipeById;
	}

}
