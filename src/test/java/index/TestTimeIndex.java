package index;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import containers.Recipe;
import index.IndexTime;

class TestTimeIndex {

	@Test
	void test() {
		Recipe r1 = new Recipe();
		r1.setCookTime(30);
		Recipe r2 = new Recipe();
		r2.setCookTime(30);
		Recipe r3 = new Recipe();
		r3.setCookTime(45);
		Recipe r4 = new Recipe();
		r4.setCookTime(60);
		Recipe r5 = new Recipe();
		r5.setCookTime(60);
		Recipe r6 = new Recipe();
		r6.setCookTime(75);
		
		List<Recipe> l30 = new ArrayList<Recipe>();
		l30.add(r1);
		l30.add(r2);
		List<Recipe> l45 = new ArrayList<Recipe>();
		l45.add(r3);
		List<Recipe> l60 = new ArrayList<Recipe>();
		l60.add(r4);
		l60.add(r5);
		List<Recipe> l75 = new ArrayList<Recipe>();
		l75.add(r6);
		
		HashMap<Integer, List<Recipe>> ans = new HashMap<Integer, List<Recipe>>();
		ans.put(30, l30);
		ans.put(45, l45);
		ans.put(60, l60);
		ans.put(75, l75);
		
		HashMap<Integer, Recipe> recipeById = new HashMap<Integer, Recipe>();
		recipeById.put(1, r1);
		recipeById.put(2, r2);
		recipeById.put(3, r3);
		recipeById.put(4, r4);
		recipeById.put(5, r5);
		recipeById.put(6, r6);

		
		IndexTime indexTime = new IndexTime(recipeById);
		HashMap<Integer, List<Recipe>> res = indexTime.index();
		
		assertEquals(ans, res);

	}

}