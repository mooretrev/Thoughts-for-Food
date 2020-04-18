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
		
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		Recipe r1 = new Recipe();
		Recipe r2 = new Recipe();
		Recipe r3 = new Recipe();		
		
		r1.setIngredients(Arrays.asList("apple", "pear"));
		r2.setIngredients(Arrays.asList("apple", "plum"));
		r3.setIngredients(Arrays.asList("apple", "plum"));
		
		HashMap<Integer, Recipe> input = new HashMap<Integer, Recipe>();
		input.put(1, r1);
		input.put(2, r2);
		input.put(3, r3);

		
		HashMap<String, List<Recipe>> ans = new HashMap<String, List<Recipe>>();
		ans.put("apple", Arrays.asList(r1, r2, r3));
		ans.put("pear", Arrays.asList(r1));
		ans.put("plum", Arrays.asList(r2, r3));
		
		IndexIngredents indexIngredents = new IndexIngredents(input);
		HashMap<String, List<Recipe>> res = indexIngredents.index();
		
		assertEquals(ans, res);


	}

}
