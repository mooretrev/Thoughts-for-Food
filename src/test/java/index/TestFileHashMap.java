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
		
		FileObject file = new FileObject();
		file.save(map, "test");
		HashMap<Integer, String> res = (HashMap<Integer, String>) file.load("test");
		
		HashMap<Integer, String> ans = map;
		
		assertEquals(ans, res);
		
	}
	

}
