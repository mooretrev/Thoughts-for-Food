package search;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import java.util.*;

import containers.Data;
import containers.Recipe;
import results.Results;

public class IngredientSearch extends AbstractSearch {

	public IngredientSearch(Data data) {
		super(data);
	}

	// ingredients in query separated by commas
	@Override
	public Results search(String query) {
		//get the hashmap of ingredients->recipes
		
		HashMap<String, List<Recipe>> recipesByIngredient = data.recipeByIngredent;

		List<List<Recipe>> allRecipes = new Vector();
		String[] queryList;
		queryList = query.split(",");
		
		for(int i = 0; i < queryList.length; i++){
			queryList[i] = queryList[i].trim();
		}

		
		//add each list of recipes to allRecipes
		for(String ingredient : queryList){
			allRecipes.add(recipesByIngredient.get(ingredient));
		}

		//find recipes with all three ingredients
		List<Recipe> finalr = new Vector<>();
		for(List<Recipe> r : allRecipes){
			for(Recipe c : r){
				int count = 0;
				List<String> ing = c.getIngredients();
				for(String q : queryList){
					if(ing.contains(q))
						count = count +1;
				}
				if(count == queryList.length)
					finalr.add(c);
			}
		}

		//find union of all lists in allRecipes
		Map<Recipe, Integer> numIngr = new HashMap<Recipe, Integer>();
		for(Recipe recipe : finalr){
			numIngr.put(recipe,recipe.getNumIngredients());

		}
		//order recipefreqs by freq descending order
		LinkedHashMap<Recipe, Integer> sortedRecipes = new LinkedHashMap<>();
		numIngr.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue()) 
			.forEachOrdered(x -> sortedRecipes.put(x.getKey(), x.getValue()));

		List<Recipe> finalRecipes = new Vector<>();
		for(Recipe rec : sortedRecipes.keySet()){
			finalRecipes.add(rec);
		}
		System.out.println("LENTH: " + finalRecipes.size());
		return new Results(finalRecipes);
	}


}