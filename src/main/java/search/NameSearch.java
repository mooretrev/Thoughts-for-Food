package search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
		List<Recipe> finalRecipes = new Vector<>();
		Collection<Recipe> r = data.recipeById.values();
		List<Recipe> recipes = new ArrayList<Recipe>(r);

		for (int i = 0; i < recipes.size(); i++) {
			if(recipes.get(i).getName().contains(query)){
				finalRecipes.add(recipes.get(i));
			}
		}

		return new Results(finalRecipes);
	}

}

