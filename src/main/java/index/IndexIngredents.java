package index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import containers.Recipe;

public class IndexIngredents {
	private HashMap<Integer, Recipe> recipeById;
	
	public IndexIngredents(HashMap<Integer, Recipe> recipeById) {
		this.recipeById = recipeById;
	}

	public HashMap<String, List<Recipe>> index() {
		HashMap<String, List<Recipe>> recipeByIngredent = new HashMap<String, List<Recipe>>();
		List<String> ingredents = getAllIngredents();
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		for(String ingredent : ingredents) {
			for(Recipe r : recipeById.values()) {
				if(r.hasIngredent(ingredent)) {
					recipes.add(r);
				}
			}
			recipeByIngredent.put(ingredent, recipes);
		}
		return recipeByIngredent;
	}

	public List<String> getAllIngredents() {
		
		for(Integer key : recipeById.keySet()) {
			System.out.println(key);
		}
		return null;
	}
	

}
