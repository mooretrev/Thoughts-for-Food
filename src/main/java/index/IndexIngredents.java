package index;

import java.util.ArrayList;
import set.SetUnion;

import java.util.HashMap;
import java.util.HashSet;
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
			System.out.println("i: " + ingredent);
			recipes = new ArrayList<Recipe>();
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
		ArrayList<Integer> keys = new ArrayList<Integer>();
		keys.addAll(recipeById.keySet());
		
		HashSet<String> set = new HashSet<String>(recipeById.get(keys.get(0)).getIngredients());
		
		for(Integer key : keys) {
			System.out.println("key: " + key);
			HashSet<String> tempSet = new HashSet<String>(recipeById.get(key).getIngredients());
			
			set.addAll(tempSet);
			
		}
		List<String> res = new ArrayList<String>(set);
		return res;
	}
	

}
