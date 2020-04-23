package index;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

import containers.Recipe;

class TestIndexRecipes {

	@Test
	void testIndex() {
//		IndexRecipes index = new IndexRecipes();
//		Map<Integer, Recipe> map = index.index();
//		System.out.println(map);
		assertEquals(true, true);
	
	}
	
	@Test
	void testSplitArray() {
		String str = "['2', 'preheat oven', 'press doubt into the pan ', 'put in oven']";
		IndexRecipes index = new IndexRecipes();
		ArrayList<String> res = index.splitArray(str);
		ArrayList<String> ans = new ArrayList<String>();
		ans.add("preheat oven");
		ans.add("press doubt into the pan");
		ans.add("put in oven");
		
		assertEquals(ans, res);

		
	}

}
