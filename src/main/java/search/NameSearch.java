package search;

import java.util.*;

import containers.Data;
import containers.Recipe;
import results.Results;

public class NameSearch extends AbstractSearch {

	public NameSearch(Data data) {
		super(data);
	}

	@Override
	public Results search(String query) {
		List<Recipe> finalRecipes = new Vector<>();
		Collection<Recipe> r = data.recipeById.values();
		List<Recipe> recipes = new ArrayList(r);

		for (int i = 0; i < recipes.size(); i++) {
			if(recipes.get(i).getName().contains(query)){
				finalRecipes.add(recipes.get(i));
			}
		}

		return new Results(finalRecipes);
	}

}

