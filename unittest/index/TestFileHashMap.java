package index;

import static org.junit.jupiter.api.Assertions.*;
import index.IndexRecipes;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import containers.Recipe;

class TestFileHashMap {

	@Test
	void testFunc() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		
		FileHashMap<Integer, String> file = new FileHashMap<Integer, String>();
		file.save(map, "test");
		HashMap<Integer, String> res = file.load("test");
		
		HashMap<Integer, String> ans = map;
		
		assertEquals(ans, res);
		
		IndexRecipes index = new IndexRecipes();
		
		FileHashMap<Integer, Recipe> file2 = new FileHashMap<Integer, Recipe>();

		HashMap<Integer, Recipe> ans2 = index.index();
		file2.save(ans2, "recipeById");
		HashMap<Integer, Recipe> res2 = file2.load("recipeById");
	}
	

}
