package results;

import java.util.Collections;
import java.util.List;

import containers.Recipe;

public class Results {
	private List<Recipe> recipes;

	public Results(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	public List<Recipe> getRecipes() {
        return recipes;		
	}
	
	public List<Recipe> sortByName(){
		Collections.sort(recipes, new SortName());
        return recipes;		
	}
	
	public List<Recipe> sortByCookTime(){
		Collections.sort(recipes, new SortCookTime());
        return recipes;	
	}
	
	public List<Recipe> sortByNumIngredents(){
		Collections.sort(recipes, new SortNumIngredients());
        return recipes;	

	}

}
