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
		System.out.println("IN SEARCH");
		List<Recipe> finalRecipes = new Vector<>();
		

		Collection<Recipe> recipes = data.recipeById.values();
		Iterator<Recipe> itr = recipes.iterator();
		System.out.println("after vector");
		System.out.println("Traversing over Set using Iterator"); 
		while(itr.hasNext()){ 
			if(query == itr.next().getName()){
				finalRecipes.add(itr.next());
			}
		}

		return new Results(finalRecipes);
	}

}
