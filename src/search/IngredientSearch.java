package search;

import java.util.*;

import containers.Data;
import containers.Recipe;
import index.IndexIngredents;
import index.IndexRecipes;

public class IngredientSearch extends AbstractSearch {

	public IngredientSearch(Data data) {
		super(data);
	}

	// ingredients in query separated by commas
	@Override
	public List<Recipe> search(String query) {
		//get the hashmap of ingredients->recipes
		IndexRecipes r = new IndexRecipes();
		IndexIngredents i = new IndexIngredents();;
		HashMap<Integer,Recipe> recipesByID = r.index();
		HashMap<String, List<Recipe>> recipesByIngredient = i.index(recipesByID);

		List<List<Recipe>> allRecipes = new Vector();
		String[] queryList;
		queryList = query.split(",");
		//add each list of recipes to allRecipes
		for(String ingredient : queryList){
			allRecipes.add(recipesByIngredient.get(ingredient));
		}
		//find union of all lists in allRecipes
		Map<Recipe, Integer> recipeFreqs = new Map<>();
		for(List<Recipe> list : allRecipes){
			for(Recipe recipe : list){
				if(recipeFreqs.containsKey(recipe))
					//add one to frequency if already in hashmap
					recipeFreqs.replace(recipe, recipeFreqs.get(recipe) + 1);
				else{
					//else make freq = 1
					recipeFreqs.put(recipe, 1);
				}

			}
		}
		//order recipefreqs by freq descending order
		LinkedHashMap<Recipe, Integer> sortedRecipes = new LinkedHashMap<>();
		recipeFreqs.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
			.forEachOrdered(x -> sortedRecipes.put(x.getKey(), x.getValue()));

		System.out.println("Sorted Recipes: " + sortedRecipes);
		List<Recipe> finalRecipes = new Vector<>();
		for(Recipe rec : sortedRecipes.keySet()){
			finalRecipes.add(rec);
		}

		return finalRecipes;
	}


}