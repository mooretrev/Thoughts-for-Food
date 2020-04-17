package index;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import containers.Data;
import containers.Recipe;

class TestIngredentIndex {

	@Test
	void test() {
		Data data = new Data();
		data.load();
		
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		Recipe r1 = new Recipe();
		Recipe r2 = new Recipe();
		Recipe r3 = new Recipe();		
		
		r1.setIngredients(Arrays.asList("apple", "pear"));
		r2.setIngredients(Arrays.asList("apple", "plum"));
		r3.setIngredients(Arrays.asList("apple", "plum"));
		
		HashMap<String, List<Recipe>> ans = new HashMap<String, List<Recipe>>();
		ans.put("apple", Arrays.asList(r1, r2, r3));
		ans.put("pear", Arrays.asList(r1));
		ans.put("plum", Arrays.asList(r2, r3));
		
		IndexIngredents indexIngredents = new IndexIngredents(data.recipeById);
		HashMap<String, List<Recipe>> res = indexIngredents.index();


		


	}
	
	@Test
	void test2() {
		Data data = new Data();
		data.load();
		IndexIngredents indexIngredents = new IndexIngredents(data.recipeById);
		indexIngredents.getAllIngredents();

	}

}
