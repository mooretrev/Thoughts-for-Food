package containers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import results.Results;

class TestResults {
	
	private List<Recipe> list;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Results results;
	
	public TestResults() {
		list = new ArrayList<Recipe>();
		
		r1 = new Recipe();
		r1.setCookTime(30);
		r1.setName("apple");
		r1.setNumIngredients(4);
		
		r2 = new Recipe();
		r2.setCookTime(15);
		r2.setName("pear");
		r2.setNumIngredients(5);

		r3 = new Recipe();
		r3.setCookTime(45);
		r3.setName("banana");
		r3.setNumIngredients(1);
		
		r4 = new Recipe();
		r4.setCookTime(75);
		r4.setName("candy");
		r4.setNumIngredients(3);
		
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		
		results = new Results(list);
	}

	@Test
	void testSortByName() {
		
		List<Recipe> ans = new ArrayList<Recipe>();
		ans.add(r1);
		ans.add(r3);
		ans.add(r4);
		ans.add(r2);
		
		List<Recipe> res = results.sortByName();
		
		assertEquals(ans, res);
	}
	
	@Test
	void testSortByCookTime() {
		
		List<Recipe> ans = new ArrayList<Recipe>();
		ans.add(r2);
		ans.add(r1);
		ans.add(r3);
		ans.add(r4);
		
		List<Recipe> res = results.sortByCookTime();
		
		assertEquals(ans, res);
	}
	
	@Test
	void testSortByNumIngrdients() {
		
		List<Recipe> ans = new ArrayList<Recipe>();
		ans.add(r3);
		ans.add(r4);
		ans.add(r1);
		ans.add(r2);
		
		List<Recipe> res = results.sortByNumIngredents();
		
		assertEquals(ans, res);
	}
	

}
