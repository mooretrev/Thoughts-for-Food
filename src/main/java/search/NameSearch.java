package search;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import containers.Data;
import containers.Recipe;
import results.Results;

public class NameSearch extends AbstractSearch {

	public NameSearch(Data data) {
		super(data);
	}

	@Override
	public Results search(String query) {
		HashMap<Integer, Recipe> recipesByName = data.recipeById;
		List<Recipe> finalRecipes = new Vector<>();

		for(Integer id : recipesByName.keySet()){
			if(query == recipesByName.get(id).getName()){
				finalRecipes.add(recipesByName.get(id));
			}
		}
		return new Results(finalRecipes);
	}

}
