package search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import containers.Data;
import containers.Recipe;
import search.NameSearch;

class TestNameSearch {

	@Test
	void test() {
		Data data = new Data();
		data.recipeById = makeRecipes();
		
		NameSearch search = new NameSearch(data);
		System.out.println(search.search("peanut"));
		
	}
	
	HashMap<Integer, Recipe>  makeRecipes() {
		Recipe r1 = new Recipe("apple pie");
		Recipe r2 = new Recipe("apple cobbler");
		Recipe r3 = new Recipe("apple slices");
		Recipe r4 = new Recipe("carmal apple");
		Recipe r5 = new Recipe("peanut butter apple");

		Recipe r6 = new Recipe("steak");
		Recipe r7 = new Recipe("ribeye steak");
		Recipe r8 = new Recipe("steak sandwhich");
		Recipe r9 = new Recipe("steak night dinner");
		Recipe r10 = new Recipe("reverse sear steak");

		Recipe r11 = new Recipe("house salad");
		Recipe r12 = new Recipe("ceaser salad");
		Recipe r13 = new Recipe("yummy salad");
		Recipe r14 = new Recipe("yucky salad");
		Recipe r15 = new Recipe("market salad");
		
		List<Recipe> recipes = Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
		
		HashMap<Integer, Recipe> recipeById = new HashMap<Integer, Recipe>();
		
		for(int i = 0; i < 15; ++i) {
			recipeById.put(i, recipes.get(i));
		}

		return recipeById;
	}

}
