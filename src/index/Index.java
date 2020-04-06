package index;

import java.util.HashMap;

import containers.Data;
import containers.Recipe;

public class Index {
	
	public void createIndex() {
		IndexRecipes indexRecipes = new IndexRecipes();
		HashMap<Integer, Recipe> recipeById = indexRecipes.index();
		
	}
	
	public Data loadIndex() {
		return null;
	}

}
